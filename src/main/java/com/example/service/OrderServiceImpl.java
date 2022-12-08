package com.example.service;

import com.example.repository.CustomerDao;
import com.example.repository.OrderDao;
import com.example.repository.ProductDao;
import com.example.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrdersService{
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public String placeOrder(Orders orders) {
        orderDao.save(orders);
        Integer customer_id = orders.getCustomer().getCustomer_id();
        Optional<Customer> opt = customerDao.findById(customer_id);
        Integer amount = 0;
        if(opt.isPresent()) {
//            System.out.println("present");
            Cart cart = opt.get().getCart();
            Set<CartItems> cartItemsList = cart.getCartItemsList();
//            System.out.println(cartItemsList);
//            amount = 0;
            for(CartItems c : cartItemsList) {
                if(c.getProduct().getQuantity() >= c.getQuantity()) {
                    Integer product_id = c.getProduct().getProduct_id();
                    Optional<Product> opt2 = productDao.findById(product_id);
                    opt2.get().setQuantity(opt2.get().getQuantity() - c.getQuantity());
                    productDao.save(opt2.get());
                    amount = opt2.get().getPrice() * c.getQuantity();
                    System.out.println("AMOUNT" + amount);
                } else {
                    return "the number of items ordered are not available";
                }
            }
        }
        return "order successfully placed! "+ "\n" + " total amount to be paid is" + " " +amount;
    }
}
