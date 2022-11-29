package com.example.controller;

import com.example.service.CartItemService;
import com.example.service.model.CartItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartitem")
public class CartItemsController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/")
    public ResponseEntity<CartItems> addNewCartItem(@RequestBody CartItems cartItems) {
        return new ResponseEntity<>(cartItemService.addCartItem(cartItems), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CartItems>> getAllCartItems() {
        return new ResponseEntity<>(cartItemService.getAllCartItems(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{cartItem_id}/")
    public ResponseEntity<CartItems> getCartItemById(@PathVariable("cartItem_id") Integer cartItem_id) {
        return new ResponseEntity<>(cartItemService.getCartItemById(cartItem_id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{cartItem_id}/")
    public ResponseEntity<CartItems> updateCartItem(@PathVariable("cartItem_id") Integer cartItem_id, @RequestBody CartItems cartItems) {
        return new ResponseEntity<>(cartItemService.updateCartItem(cartItems, cartItem_id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{cartItem_id}/")
    public ResponseEntity<String> deleteCartItem(@PathVariable("cartItem_id") Integer cartItem_id) {
        return new ResponseEntity<>(cartItemService.deleteCartItem(cartItem_id), HttpStatus.ACCEPTED);
    }
}
