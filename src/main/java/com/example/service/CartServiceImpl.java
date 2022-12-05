package com.example.service;

import com.example.repository.CartDao;
import com.example.repository.CustomerDao;
import com.example.service.model.Cart;
import com.example.service.model.Customer;
import com.example.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Cart> getAllCarts() {
        List<Cart> list = cartDao.findAll();
        return list;
    }

    @Override
    public String delete(Integer cart_id) {
        cartDao.deleteById(cart_id);
        return "cart successfully deleted";
    }

    @Override
    public Cart updateCart(Cart cart, Integer cart_id) {
        return null;
    }

    @Override
    public Cart getCart(Integer cart_id) {
        Optional<Cart> opt = cartDao.findById(cart_id);
        if(opt.isPresent()) return opt.get();
        return null;
    }

    @Override
    public Cart addCart(Cart cart) {
        Optional<Customer> opt = customerDao.findById(cart.getCustomer().getCustomer_id());
        if(opt.isPresent()) {
            Customer customer = opt.get();
            customer.setCart(cart);
        }
        cartDao.save(cart);
        return cart;
    }
}
