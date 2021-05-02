package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Users;
import com.example.happywagon.dao.ArtistDao;
import com.example.happywagon.dao.UserDao;
import com.example.happywagon.services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ArtistDao artistDao;

    @Override
    public Users login(String username, String password){
        System.out.println("service "+username+"  "+password);
        return userDao.findByUsernameEqualsAndPasswordEquals(username,password);

    }

    @Override
    public String changePassword(String email,String old, String newp, String newp2) {
        String check = userDao.getPasswordByEmail(email);
//        System.out.println(old);
//        System.out.println(check);
        if(!old.equals(check)) return "Old password does not match";
        if(!newp.equals(newp2)) return "Confirm password does not match";
        userDao.updatePassword(email,newp);
        artistDao.updatePassword(email,newp);
        return "Success";
    }
}
