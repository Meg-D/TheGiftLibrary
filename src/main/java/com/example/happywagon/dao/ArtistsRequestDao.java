package com.example.happywagon.dao;


import com.example.happywagon.bean.Artist_Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistsRequestDao extends JpaRepository<Artist_Requests, Integer> {
}
