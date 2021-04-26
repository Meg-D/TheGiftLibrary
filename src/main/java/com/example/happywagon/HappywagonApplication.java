package com.example.happywagon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HappywagonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappywagonApplication.class, args);
    }

}
