package com.example.happywagon.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Register implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String website;
    @Column(unique = true)
    private String number;
    private String about;
    @Column(unique = true)
    private String photo;

    @Column(nullable = false)
    private String password;

    public Register() {
    }

    public Register(Integer request_id, String name, String email, String website, String number, String about, String photo, String password) {
        this.request_id = request_id;
        this.name = name;
        this.email = email;
        this.website = website;
        this.number = number;
        this.about = about;
        this.photo = photo;
        this.password = password;

    }


    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
