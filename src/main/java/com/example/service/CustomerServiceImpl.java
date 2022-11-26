package com.example.service;

import com.example.repository.CustomerDao;
import com.example.service.model.Customer;
import com.example.service.model.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public CustomerDTO registerCustomer(Customer customer) {
        customerDao.save(customer);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(Integer customer_id) {
        Optional<Customer> opt = customerDao.findById(customer_id);
        Customer customer = opt.get();
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> list = customerDao.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer c : list) {
            CustomerDTO customerDTO = modelMapper.map(c, CustomerDTO.class);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String removeCustomer(Integer customer_id) {
        customerDao.deleteById(customer_id);
        return "customer successfully deleted";
    }

    @Override
    public CustomerDTO updateCustomer(Integer customer_id, Customer customer) {
        Optional<Customer> opt = customerDao.findById(customer_id);
        if(opt.isPresent()) {
            customer.setCustomer_id(customer_id);
        }
        else {
            return null;
        }
        customerDao.save(customer);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }
}
