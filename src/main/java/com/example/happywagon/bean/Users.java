package com.example.happywagon.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Users implements Serializable {

    @Id
    @Column(unique = true,nullable = false,length=64)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer type;
    //1-admin 2-artist


    public Users(){
    }

    public Users(String username, String password, Integer type) {
        this.username = username;
        this.password = password;
        this.type = type;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
