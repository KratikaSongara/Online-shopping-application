package com.example.service;

import com.example.service.model.Category;
import com.example.repository.CategoryDao;
import com.example.service.model.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category addCategory(Category category) {
        categoryDao.save(category);
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = categoryDao.findAll();
        return list;
    }

    @Override
    public Category getCategoryById(Integer category_id) {
        Optional<Category> opt = categoryDao.findById(category_id);
        return opt.get();
    }

    @Override
    public String deleteCategory(Integer category_id) {
        categoryDao.deleteById(category_id);
        return "category successfully deleted";
    }

    @Override
    public Category updateCategory(Integer category_id, Category category) {
        Optional<Category> opt = categoryDao.findById(category_id);
        if(opt.isPresent()) {
            category.setCategory_id(category_id);
        }
        categoryDao.save(category);
        return category;
    }

    //FOR CUSTOMERS
    @Override
    public List<CategoryDTO> getAllCategoriesForCustomer() {
        List<Category> list = categoryDao.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(Category category : list) {
            CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
//            System.out.println(categoryDTO);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
