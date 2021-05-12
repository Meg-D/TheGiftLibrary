package com.example.happywagon.controller;

import com.example.happywagon.JSONentity.Password;
import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Users;
import com.example.happywagon.services.ArtistsService;
import com.example.happywagon.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    ArtistsService artistService;

    // login
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping(path = "/login")
    public Users login(@RequestBody Users credentials) {
        System.out.println("controller : " + credentials.getUsername() + "  " + credentials.getPassword());
        Users u = this.usersService.login(credentials.getUsername(),credentials.getPassword());
        return u;
    }

    // password
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path= "/password",produces={"application/TEXT"},consumes = {"application/JSON"})
    public String password(@RequestBody Password pass){
        String status = this.usersService.changePassword(pass.getEmail(),pass.getOld(),pass.getNewp(),pass.getNewp2());
        return status;
    }


}
