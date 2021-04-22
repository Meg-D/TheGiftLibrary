package com.example.happywagon.bean;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    @Column(nullable = false,unique = false)
    private String name;
    private String about;

    public Categories() {
    }

    public Categories(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

