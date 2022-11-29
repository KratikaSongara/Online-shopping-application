package com.example.service;

import com.example.service.model.Cart;
import com.example.service.model.CartItems;

import java.util.List;

public interface CartItemService {
    public CartItems addCartItem(CartItems cartItems);
    public CartItems updateCartItem(CartItems cartItems, Integer cartItem_id);
    public List<CartItems> getAllCartItems();
    public CartItems getCartItemById(Integer cartItem_id);
    public String deleteCartItem(Integer cartItem_id);
}
