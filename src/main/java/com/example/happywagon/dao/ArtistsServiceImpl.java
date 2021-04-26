package com.example.happywagon.dao;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    @Autowired
    private ArtistDao artistDao;

    public ArtistsServiceImpl(){
    }

    @Override
    public List<Artists> getArtists(){
       // System.out.println("inside impl");
        return artistDao.findAll();
    }

    @Override
    public Optional<Artists> getArtist(Integer artistId){
        Optional<Artists> entity = artistDao.findById(artistId);
        System.out.println(entity);
        return entity;
    }

    @Override
    public Artists addArtist(Artists artist){
        artistDao.save(artist);
        return artist;
    }

    @Override
    public Artists updateArtist(Artists artist){
        artistDao.save(artist);
        return artist;
    }

    @Override
    public void deleteArtist(int artistId){
        Artists entity = artistDao.getOne(artistId);
        artistDao.delete(entity);
    }
}
