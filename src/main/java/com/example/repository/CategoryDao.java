package com.example.repository;

import com.example.service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
    @Query("from Category where category_name=?1")
    public Category findByName(String category_name);
}
