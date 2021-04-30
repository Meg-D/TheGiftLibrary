package com.example.happywagon.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Artist_Requests implements Serializable {

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
    private long number;
    private String about;
    @Column(unique = true)
    private String photo;

    @OneToOne
    Users username;

    @Column(nullable = false)
    private String password;

    public Artist_Requests() {
    }

    public Artist_Requests(Integer request_id, String name, String email, String website, long number, String about, String photo, Users username, String password) {
        this.request_id = request_id;
        this.name = name;
        this.email = email;
        this.website = website;
        this.number = number;
        this.about = about;
        this.photo = photo;
        this.username = username;
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

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
