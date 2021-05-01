package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Users;
import com.example.happywagon.dao.UserDao;
import com.example.happywagon.services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users login(String username, String password){
        System.out.println("service "+username+"  "+password);
        return userDao.findByUsernameEqualsAndPasswordEquals(username,password);

    }
}
