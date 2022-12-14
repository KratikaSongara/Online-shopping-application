package com.example.service;

import com.example.repository.CartDao;
import com.example.repository.CartItemDao;
import com.example.service.model.Cart;
import com.example.service.model.CartItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    private CartItemDao cartItemDao;

    @Autowired
    private CartDao cartDao;

    @Override
    public CartItems addCartItem(CartItems cartItems) {
        cartItemDao.save(cartItems);
        Integer cart_id = cartItems.getCart().getCart_id();
        Optional<Cart> opt = cartDao.findById(cart_id);
        if(opt.isPresent()) {
            opt.get().getCartItemsList().add(cartItems);
            cartDao.save(opt.get());
        }
        return cartItems;
    }

    @Override
    public CartItems updateCartItem(CartItems cartItems, Integer cartItem_id) {
        Optional<CartItems> opt = cartItemDao.findById(cartItem_id);
        if(!opt.isPresent()) return null;
        cartItems.setCartItem_id(cartItem_id);
        cartItemDao.save(cartItems);
        return cartItems;
    }

    @Override
    public List<CartItems> getAllCartItems() {
        List<CartItems> list = cartItemDao.findAll();
        System.out.println(list);
        return list;
    }

    @Override
    public CartItems getCartItemById(Integer cartItem_id) {
        Optional<CartItems> opt = cartItemDao.findById(cartItem_id);
        if(!opt.isPresent()) return null;
        return opt.get();
    }

    @Override
    public String deleteCartItem(Integer cartItem_id) {
        Optional<CartItems> opt = cartItemDao.findById(cartItem_id);
        if(!opt.isPresent()) return null;
        cartItemDao.deleteById(cartItem_id);
        return "cart item deleted successfully";
    }
}
