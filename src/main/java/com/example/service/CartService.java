package com.example.service;

import com.example.service.model.Cart;
import com.example.service.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CartService {
    public List<Cart> getAllCarts();
    public Cart addProduct(Integer cart_id, Product product);
    public String delete(Integer cart_id);
    public Cart updateCart(Cart cart, Integer cart_id);
    public Cart getCart(Integer cart_id);
    public Cart addCart(Cart cart);
}
