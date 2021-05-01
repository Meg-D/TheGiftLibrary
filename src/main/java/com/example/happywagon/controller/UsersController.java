package com.example.happywagon.controller;

import com.example.happywagon.bean.Users;
import com.example.happywagon.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;
    // login
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path = "/login",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<Users> login(@RequestBody Users credentials) {
        System.out.println("controller : " + credentials.getUsername() + "  " + credentials.getPassword());
        Users u = this.usersService.login(credentials.getUsername(),credentials.getPassword());
        if (u == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
