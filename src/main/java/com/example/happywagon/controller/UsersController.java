package com.example.happywagon.controller;

import com.example.happywagon.JSONentity.Password;
import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Users;
import com.example.happywagon.services.ArtistsService;
import com.example.happywagon.services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
public class UsersController {

    Logger logger = LoggerFactory.getLogger(ArtistsController.class);

    @Autowired
    UsersService usersService;

    // login
    @PostMapping(path="/login")
    public Users login(@RequestBody Users credentials) {
        System.out.println("controller : " + credentials.getUsername() + "  " + credentials.getPassword());
        logger.info("trying to login with credentials as username: "+credentials.getUsername() + " password: "+credentials.getPassword());
        Users u = this.usersService.login(credentials.getUsername(),credentials.getPassword());
        return u;
    }

    // password
    @PostMapping(path= "/password",produces={"application/TEXT"},consumes = {"application/JSON"})
    public String password(@RequestBody Password pass){
        logger.info("trying to change password");
        String status = this.usersService.changePassword(pass.getEmail(),pass.getOld(),pass.getNewp(),pass.getNewp2());
        return status;
    }

}
