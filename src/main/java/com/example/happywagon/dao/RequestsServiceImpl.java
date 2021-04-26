package com.example.happywagon.dao;

import com.example.happywagon.bean.Requests;
import com.example.happywagon.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsServiceImpl implements RequestsService {

    @Autowired
    private RequestDao requestDao;

    @Override
    public List<Requests> getRequests() {
        return requestDao.findAll();
    }

    @Override
    public Requests addRequest(Requests request) {
        requestDao.save(request);
        return request;
    }

    @Override
    public void deleteRequest(int request_id) {
        Requests entity = requestDao.getOne(request_id);
        requestDao.delete(entity);
    }
}
