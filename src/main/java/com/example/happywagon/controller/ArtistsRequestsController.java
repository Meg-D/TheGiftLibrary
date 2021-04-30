package com.example.happywagon.controller;

import com.example.happywagon.bean.Artist_Requests;
import com.example.happywagon.services.ArtistsRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistsRequestsController {

    @Autowired
    public ArtistsRequestsService artistsRequestService;

    //get all the requests
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/arequests")
    public List<Artist_Requests> getRequests(){
        // System.out.println("inside controller");
        return this.artistsRequestService.getArtistsRequests();
    }

    //add request
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path="/arequests",consumes = "application/JSON")
    public Artist_Requests addRequest(@RequestBody Artist_Requests request){
        return this.artistsRequestService.addArtistRequest(request);
    }

    //delete request
    @CrossOrigin(origins="http://localhost:3000")
    @DeleteMapping("/arequest/{requestId}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable String requestId){
        try{
            this.artistsRequestService.deleteArtistRequest(Integer.parseInt(requestId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
