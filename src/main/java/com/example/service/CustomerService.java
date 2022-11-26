package com.example.service;

import com.example.service.model.Customer;
import com.example.service.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public CustomerDTO registerCustomer(Customer customer);
    public CustomerDTO getCustomerById(Integer customer_id);
    public List<CustomerDTO> getAllCustomer();
    public String removeCustomer(Integer customer_id);
    public CustomerDTO updateCustomer(Integer customer_id, Customer customer);
}
