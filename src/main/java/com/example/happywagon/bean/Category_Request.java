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
    private String about;
    private String photo;

    public Category_Request(){
    }

    public Category_Request( Integer request_id, String name, String about, String photo) {
        this.request_id = request_id;
        this.name = name;
        this.about = about;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
