package com.example.happywagon.services;

import com.example.happywagon.bean.Register;

import java.util.List;

public interface ArtistsRequestsService {
    public List<Register> getArtistsRequests();

    public Register addArtistRequest(Register request);
    public void deleteArtistRequest(int request_id);

}
