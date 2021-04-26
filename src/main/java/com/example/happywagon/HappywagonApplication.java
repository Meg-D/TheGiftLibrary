package com.example.happywagon;

import com.example.happywagon.bean.Users;
import com.example.happywagon.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HappywagonApplication {
    static UserDao userDao;
    public static void main(String[] args) {
        SpringApplication.run(HappywagonApplication.class, args);


        Users admin = new Users();
        admin.setUsername("admin");
        admin.setPassword("password");
        admin.setType(1);

        userDao.save(admin);
    }


}
