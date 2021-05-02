package com.example.happywagon.services;

import com.example.happywagon.bean.Users;

public interface UsersService {

    public Users login(String username, String password);

    String changePassword(String email, String old, String newp, String newp2);
}
