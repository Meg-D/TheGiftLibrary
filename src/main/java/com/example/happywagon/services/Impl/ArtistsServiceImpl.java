package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Register;
import com.example.happywagon.bean.Users;
import com.example.happywagon.dao.ArtistDao;
import com.example.happywagon.dao.UserDao;
import com.example.happywagon.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    @Value("${image_upload_location}")
    private String image_location;

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
    public Artists getArtistById(int artistId) {
        return artistDao.findById(artistId).get();
    }


    @Override
    public String registerArtist(Register artist) {
        System.out.println("in seriveimpl");
        System.out.println(artist);
        String check = artistDao.checkEmail(artist.getEmail());
        if(check != null){
            return "not";
        }

        Integer id = artistDao.getNextArtistId();
        id++;

        // directly storing to Artists table
        Artists entity1 = new Artists(id,artist.getName(),artist.getEmail(),artist.getPassword(),artist.getWebsite(),artist.getNumber(),artist.getAbout(),artist.getPhoto());
        artistDao.save(entity1);
        Users entity2 = new Users(artist.getEmail(),artist.getPassword(),2);
        userDao.save(entity2);
        return "ok";
    }



    @Override
    public Resource loadImage(Artists artists) {
        try {
            Path upload_location = Paths.get(image_location);
            Path file = upload_location.resolve(artists.getPhoto());
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException error) {
            System.out.println("Error: [loadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }


    @Override
    public String uploadImage(MultipartFile image, Artists artists) {
        if (image.getOriginalFilename() == null) {
            return null;
        }
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        if (image.isEmpty()) {
            return null;
        }
        if (fileName.contains("..")) {
            fileName = fileName.replace("..", "_");
        }
        try (InputStream inputStream = image.getInputStream()) {
            Path upload_location = Paths.get(image_location);
            fileName = fileName + "_" + artists.getArtist_id();
            Files.copy(inputStream, upload_location.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException error) {
            System.out.println("Error: [uploadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }

}
