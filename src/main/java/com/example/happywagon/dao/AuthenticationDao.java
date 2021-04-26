package com.example.happywagon.dao;

import com.example.happywagon.bean.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationDao extends JpaRepository<Authentication, Integer> {
}
