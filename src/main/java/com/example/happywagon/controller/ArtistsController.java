package com.example.happywagon.controller;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistsController {

    @Autowired
    public ArtistsService artistService;

    //get all the artists
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/artists")
    public List<Artists> getArtists(){
       // System.out.println("inside controller");
        return this.artistService.getArtists();
    }

   //get one artist
   @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/artists/{artistId}")
    public Optional<Artists> getArtist(@PathVariable String artistId){
        return this.artistService.getArtist(Integer.parseInt(artistId));
    }

    //add artist
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path="/artists",consumes = "application/JSON")
    public Artists addArtist(@RequestBody Artists artist){
        return this.artistService.addArtist(artist);
    }

    //update artist
    @CrossOrigin(origins="http://localhost:3000")
    @PutMapping("/artists")
    public Artists updateArtist(@RequestBody Artists artist){
            return this.artistService.updateArtist(artist);

    }

    //delete artist
    @CrossOrigin(origins="http://localhost:3000")
    @DeleteMapping("/artists/{artistId}")
    public ResponseEntity<HttpStatus> deleteArtist(@PathVariable String artistId){
        try{
            this.artistService.deleteArtist(Integer.parseInt(artistId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
