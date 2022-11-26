package com.example.service;

import com.example.service.model.Category;
import com.example.service.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public Category addCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategoryById(Integer category_id);
    public String deleteCategory(Integer category_id);
    public Category updateCategory(Integer category_id, Category category);

    //FOR CUSTOMERS
    public List<CategoryDTO> getAllCategoriesForCustomer();
}
