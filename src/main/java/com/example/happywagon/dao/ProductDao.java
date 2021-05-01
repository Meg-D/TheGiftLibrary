package com.example.happywagon.dao;


import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Categories;
import com.example.happywagon.bean.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProductDao extends JpaRepository<Products,Integer> {


    @Query("SELECT p FROM Products p WHERE p.art_id= :artist_id")
    List<Products> getProductsByArtist(@Param("artist_id") Artists artist_id);

    @Query("SELECT p FROM Products p WHERE p.cate_id= :category_id")
    List<Products> getProductsByCategory(@Param("category_id") Categories category_id);


}
