package com.example.happywagon.services;

import com.example.happywagon.bean.Requests;

import java.util.List;

public interface RequestsService {
    public List<Requests> getRequests();

    public Requests addRequest(Requests request);
    public void deleteRequest(int request_id);

}
