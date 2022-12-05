package com.example.controller;

import com.example.service.OrdersService;
import com.example.service.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/")
    public ResponseEntity<Orders> placeOrder(@RequestBody Orders orders) {
        return new ResponseEntity<>(ordersService.placeOrder(orders), HttpStatus.ACCEPTED);
    }
}
