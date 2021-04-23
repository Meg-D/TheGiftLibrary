package com.example.happywagon.dao;

import com.example.happywagon.bean.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Categories,Integer> {
}
