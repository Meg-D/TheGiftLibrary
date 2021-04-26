package com.example.happywagon.dao;

import com.example.happywagon.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, Integer> {
}
