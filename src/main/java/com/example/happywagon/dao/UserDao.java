package com.example.happywagon.dao;

import com.example.happywagon.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
    Users findByUsernameEqualsAndPasswordEquals(String username, String password);
    Users findByUsernameEquals(String username);

    @Query("SELECT u.password FROM Users u where u.username =:email")
    String getPasswordByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query ("UPDATE Users u SET u.password = :newp WHERE u.username=:email")
    void updatePassword(@Param("email") String email,@Param("newp") String newp);
}
