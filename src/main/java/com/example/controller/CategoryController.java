package com.example.controller;

import com.example.service.model.Category;
import com.example.service.CategoryService;
import com.example.service.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.ACCEPTED);
    }

    @GetMapping("/admin/")
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/admin/{category_id}/")
    public ResponseEntity<Category> getCategoryById(@PathVariable("category_id") Integer category_id) {
        return new ResponseEntity<>(categoryService.getCategoryById(category_id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/admin/{category_id}/")
    public ResponseEntity<String> deleteCategory(@PathVariable("category_id") Integer category_id) {
        return new ResponseEntity<>(categoryService.deleteCategory(category_id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/admin/{category_id}/")
    public ResponseEntity<Category> updateCategory(@PathVariable("category_id") Integer category_id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(category_id, category), HttpStatus.ACCEPTED);
    }

    //FOR CUSTOMERS
    @GetMapping("/customer/")
    public ResponseEntity<List<CategoryDTO>> getAllCategoriesForCustomer() {
        return new ResponseEntity<>(categoryService.getAllCategoriesForCustomer(), HttpStatus.ACCEPTED);
    }
}
