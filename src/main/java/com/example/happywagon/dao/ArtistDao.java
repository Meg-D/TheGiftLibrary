package com.example.happywagon.dao;

import com.example.happywagon.bean.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistDao extends JpaRepository<Artists, Integer> {

}
