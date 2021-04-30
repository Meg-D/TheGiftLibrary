package com.example.happywagon.dao;

import com.example.happywagon.bean.Category_Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRequestDao extends JpaRepository<Category_Request,Integer> {
}
