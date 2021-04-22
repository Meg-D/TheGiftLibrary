package com.example.happywagon.services;

import com.example.happywagon.bean.Artists;
import java.util.List;

public interface ArtistsService {
    public List<Artists> getArtists();

    public Artists getArtist(int artistId);

    public Artists addArtist(Artists artist);

    public Artists updateArtist(Artists artist);

    public void deleteArtist(int artistId);
}
