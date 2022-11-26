package com.example.service;

import com.example.service.model.Category;
import com.example.service.model.Product;
import com.example.repository.CategoryDao;
import com.example.repository.ProductDao;
import com.example.service.model.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Product addProduct(Integer category_id, Product product) {
        Optional<Category> opt = categoryDao.findById(category_id);
        opt.get().getProductList().add(product);
        product.getCategory().setCategory_name(opt.get().getCategory_name());
        productDao.save(product);
        return product;
    }

    @Override
    public Product getProduct(Integer product_id) {
        Optional<Product> opt = productDao.findById(product_id);
        if(opt.isPresent()) return opt.get();
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = productDao.findAll();
        return list;
    }

    @Override
    public String removeProduct(Integer product_id) {
        productDao.deleteById(product_id);
        return "product successfully deleted";
    }

    @Override
    public Product updateProduct(Integer category_id, Integer product_id, Product product) {
        Optional<Category> opt2 = categoryDao.findById(category_id);
        product.getCategory().setCategory_name(opt2.get().getCategory_name());
        Optional<Product> opt = productDao.findById(product_id);
        Product p1 = opt.get();
        product.setProduct_id(p1.getProduct_id());
        productDao.save(product);
        Optional<Category> opt3 = categoryDao.findById(category_id);
        opt3.get().getProductList().add(product);
        return product;
    }

    @Override
    public List<ProductDTO> getAllProductsForCustomer() {
        List<Product> list = productDao.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Product p : list) {
            ProductDTO productDTO = modelMapper.map(p, ProductDTO.class);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
}
