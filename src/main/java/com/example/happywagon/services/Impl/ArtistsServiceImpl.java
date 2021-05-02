package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Register;
import com.example.happywagon.bean.Users;
import com.example.happywagon.dao.ArtistDao;
import com.example.happywagon.dao.UserDao;
import com.example.happywagon.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private UserDao userDao;

    public ArtistsServiceImpl(){
    }

    @Override
    public List<Artists> getArtists(){
       // System.out.println("inside impl");
        return artistDao.findAll();
    }

    @Override
    public Artists getArtistByEmail(String email){
        Artists entity = artistDao.getArtistByEmail(email);
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

    @Override
    public void registerArtist(Register artist) {
        Integer id = artistDao.getNextArtistId();
        id++;
        Artists entity1 = new Artists(id,artist.getName(),artist.getEmail(),artist.getPassword(),artist.getWebsite(),artist.getNumber(),artist.getAbout(),artist.getPhoto());
        artistDao.save(entity1);
        Users entity2 = new Users(artist.getEmail(),artist.getPassword(),2);
        userDao.save(entity2);
    }
}
