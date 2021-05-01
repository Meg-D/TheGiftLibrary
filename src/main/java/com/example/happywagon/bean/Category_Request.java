package com.example.happywagon.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Category_Request  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;
    @Column(nullable = false)
    private String name;
    @Column
    private String about;

    public Category_Request(){

    }

    public Category_Request( Integer request_id, String name, String about) {
        this.request_id = request_id;
        this.name = name;
        this.about = about;
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


    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
