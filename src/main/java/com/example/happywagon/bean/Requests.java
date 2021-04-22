package com.example.happywagon.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Requests implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;
    @Column(nullable = false)
    private String status;

    @OneToOne
    private Artists artist_id; //foreign key

    public Requests() {
    }

    public Requests(String status, Artists artist_id) {
        this.status = status;
        this.artist_id = artist_id;
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Artists getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Artists artist_id) {
        this.artist_id = artist_id;
    }
}
