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
    public Orders placeOrder(Orders orders) {
        orderDao.save(orders);
        Integer customer_id = orders.getCustomer().getCustomer_id();
        Optional<Customer> opt = customerDao.findById(customer_id);
        if(opt.isPresent()) {
            System.out.println("present");
            Cart cart = opt.get().getCart();
            Set<CartItems> cartItemsList = cart.getCartItemsList();
//            System.out.println(cartItemsList);
            Integer amount = 0;
            for(CartItems c : cartItemsList) {
                if(c.getProduct().getQuantity() >= c.getQuantity()) {
                    Integer product_id = c.getProduct().getProduct_id();
                    Optional<Product> opt2 = productDao.findById(product_id);
                    opt2.get().setQuantity(opt2.get().getQuantity() - c.getQuantity());
                    amount = opt2.get().getPrice() * c.getQuantity();
                }
            }
        }
        return orders;
    }
}
