package com.example.happywagon.dao;

import com.example.happywagon.bean.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtistDao extends JpaRepository<Artists, Integer> {

    @Query("SELECT a FROM Artists a WHERE a.email= :email")
     Artists getArtistByEmail(@Param("email") String email);

    @Query("SELECT max(artist_id) FROM Artists")
    Integer getNextArtistId();

    @Transactional
    @Modifying
    @Query ("UPDATE Artists a SET a.password = :newp WHERE a.email=:email")
    void updatePassword(@Param("email") String email,@Param("newp") String newp);
}
