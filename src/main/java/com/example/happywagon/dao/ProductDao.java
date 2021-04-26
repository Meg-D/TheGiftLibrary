package com.example.happywagon.dao;


import com.example.happywagon.bean.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Products,Integer> {
}
