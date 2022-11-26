package com.example.controller;

import com.example.service.CustomerService;
import com.example.service.model.Customer;
import com.example.service.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<CustomerDTO> addNewCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.registerCustomer(customer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{customer_id}/")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customer_id") Integer customer_id) {
        return new ResponseEntity<>(customerService.getCustomerById(customer_id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{customer_id}")
    public ResponseEntity<String> removeCustomer(@PathVariable("customer_id") Integer customer_id) {
        return new ResponseEntity<>(customerService.removeCustomer(customer_id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{customer_id}/")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customer_id") Integer customer_id, @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer_id, customer), HttpStatus.ACCEPTED);
    }
}
