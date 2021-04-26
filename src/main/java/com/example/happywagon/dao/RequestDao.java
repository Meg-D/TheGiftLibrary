package com.example.happywagon.dao;


import com.example.happywagon.bean.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Requests, Integer> {
}
