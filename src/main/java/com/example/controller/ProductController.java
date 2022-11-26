package com.example.controller;

import com.example.service.model.Product;
import com.example.service.ProductService;
import com.example.service.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/admin/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/admin/{product_id}")
    public ResponseEntity<Product> findProductById(@PathVariable("product_id") Integer product_id) {
        return new ResponseEntity<>(productService.getProduct(product_id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/admin/{category_id}/")
    public ResponseEntity<Product> addProduct(@PathVariable("category_id") Integer category_id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(category_id,product), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/admin/{product_id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("product_id") Integer product_id) {
        return new ResponseEntity<>(productService.removeProduct(product_id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/admin/{category_id}/{product_id}/")
    public ResponseEntity<Product> updateProduct(@PathVariable("category_id") Integer category_id, @PathVariable("product_id") Integer product_id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(category_id, product_id, product), HttpStatus.ACCEPTED);
    }

    //FOR CUSTOMER
    @GetMapping("/customer/")
    public ResponseEntity<List<ProductDTO>> getAllProductsForCustomer() {
        return new ResponseEntity<>(productService.getAllProductsForCustomer(), HttpStatus.ACCEPTED);
    }
}
