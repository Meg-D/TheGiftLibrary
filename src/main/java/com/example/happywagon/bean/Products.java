package com.example.happywagon.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String price;

    @ManyToOne
    private Categories cate_id;

    @ManyToOne
    private Artists art_id;

    public Products() {
    }

    public Products( String name, String description, String price, Categories cate_id, Artists art_id) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.cate_id = cate_id;
        this.art_id = art_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Categories getCate_id() {
        return cate_id;
    }

    public void setCate_id(Categories cate_id) {
        this.cate_id = cate_id;
    }

    public Artists getArt_id() {
        return art_id;
    }

    public void setArt_id(Artists art_id) {
        this.art_id = art_id;
    }
}