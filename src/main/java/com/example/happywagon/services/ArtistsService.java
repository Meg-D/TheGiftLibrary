package com.example.happywagon.services;

import com.example.happywagon.bean.Artists;
import java.util.List;
import java.util.Optional;

public interface ArtistsService {
    public List<Artists> getArtists();

    public Optional<Artists> getArtist(Integer artistId);

    public Artists addArtist(Artists artist);

    public Artists updateArtist(Artists artist);

    public void deleteArtist(int artistId);
}
