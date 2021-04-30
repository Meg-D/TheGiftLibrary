package com.example.happywagon.services;

import com.example.happywagon.bean.Artist_Requests;

import java.util.List;

public interface ArtistsRequestsService {
    public List<Artist_Requests> getArtistsRequests();

    public Artist_Requests addArtistRequest(Artist_Requests request);
    public void deleteArtistRequest(int request_id);

}
