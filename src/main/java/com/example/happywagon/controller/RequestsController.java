package com.example.happywagon.controller;

import com.example.happywagon.bean.Requests;
import com.example.happywagon.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestsController {

    @Autowired
    public RequestsService requestService;

    //get all the requests
    @GetMapping("/requests")
    public List<Requests> getRequests(){
        // System.out.println("inside controller");
        return this.requestService.getRequests();
    }

    //add request
    @PostMapping(path="/requests",consumes = "application/JSON")
    public Requests addRequest(@RequestBody Requests request){
        return this.requestService.addRequest(request);
    }

    //delete request
    @DeleteMapping("/request/{requestId}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable String requestId){
        try{
            this.requestService.deleteRequest(Integer.parseInt(requestId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
