package com.example.controller;

import com.example.service.CartService;
import com.example.service.model.Cart;
import com.example.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{cart_id}/")
    public ResponseEntity<Cart> getCartById(@PathVariable("cart_id") Integer cart_id) {
        return new ResponseEntity<>(cartService.getCart(cart_id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.addCart(cart), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{cart_id}/")
    public ResponseEntity<Cart> addNewProductInACart(@PathVariable("cart_id") Integer cart_id, @RequestBody Product product) {
        return new ResponseEntity<>(cartService.addProduct(cart_id, product), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{cart_id}/")
    public ResponseEntity<Cart> updateCart(@PathVariable("cart_id") Integer cart_id, @RequestBody Cart cart) {
        return new ResponseEntity<>(cartService.updateCart(cart, cart_id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{cart_id}")
    public ResponseEntity<String> deleteCart(@PathVariable("cart_id") Integer cart_id) {
        return new ResponseEntity<>(cartService.delete(cart_id), HttpStatus.ACCEPTED);
    }
}
