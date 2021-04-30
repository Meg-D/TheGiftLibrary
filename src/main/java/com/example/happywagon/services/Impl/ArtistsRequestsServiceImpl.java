package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Artist_Requests;
import com.example.happywagon.dao.ArtistDao;
import com.example.happywagon.dao.ArtistsRequestDao;
import com.example.happywagon.services.ArtistsRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistsRequestsServiceImpl implements ArtistsRequestsService {

    @Autowired
    private ArtistsRequestDao artistsRequestDao;

    @Override
    public List<Artist_Requests> getArtistsRequests() {
        return artistsRequestDao.findAll();
    }

    @Override
    public Artist_Requests addArtistRequest(Artist_Requests request) {
        artistsRequestDao.save(request);
        return request;
    }

    @Override
    public void deleteArtistRequest(int request_id) {
        Artist_Requests entity = artistsRequestDao.getOne(request_id);
        artistsRequestDao.delete(entity);
    }
}
