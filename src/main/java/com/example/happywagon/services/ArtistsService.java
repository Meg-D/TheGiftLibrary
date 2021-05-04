package com.example.happywagon.services;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Register;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Optional;

public interface ArtistsService {
    public List<Artists> getArtists();

    public Artists getArtistByEmail(String email);

    public Artists addArtist(Artists artist);

    public Artists updateArtist(Artists artist);

    public void deleteArtist(int artistId);


    public Resource loadImage(Artists artists);

    public String registerArtist(Register artist);
}
