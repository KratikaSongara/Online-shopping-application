package com.example.service;

import com.example.service.model.Product;
import com.example.service.model.ProductDTO;

import java.util.List;

public interface ProductService {
    public Product addProduct(Integer category_id, Product product);
    public Product getProduct(Integer product_id);
    public List<Product> getAllProducts();
    public String removeProduct(Integer product_id);
    public Product updateProduct(Integer category_id, Integer product_id, Product product);

    //FOR USER
    public List<ProductDTO> getAllProductsForCustomer();
}
