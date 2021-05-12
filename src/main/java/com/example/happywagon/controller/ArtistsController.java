package com.example.happywagon.controller;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Register;
import com.example.happywagon.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ArtistsController {

    @Autowired
    public ArtistsService artistService;

    //get all the artists
    @GetMapping("/artists")
    public List<Artists> getArtists(){
       // System.out.println("inside controller");
        return this.artistService.getArtists();
    }

   //get one artist
    @GetMapping("/artists/{email}")
    public Artists getArtist(@PathVariable String email){
        return this.artistService.getArtistByEmail(email);
    }

    //add artist
    @PostMapping(path="/artists",consumes = "application/JSON")
    public Artists addArtist(@RequestBody Artists artist){
        return this.artistService.addArtist(artist);
    }

    //update artist
    @PutMapping("/artists")
    public Artists updateArtist(@RequestBody Artists artist){
            return this.artistService.updateArtist(artist);

    }

    //delete artist
    //@CrossOrigin(origins="http://localhost:3000")
    @DeleteMapping("/artists/{artistId}")
    public ResponseEntity<HttpStatus> deleteArtist(@PathVariable String artistId){
        try{
            this.artistService.deleteArtist(Integer.parseInt(artistId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get artist images
    @GetMapping(value = "/artists/image/{artistId}")
    public ResponseEntity<Resource> getArtistImage(@PathVariable String artistId) {
        System.out.println(artistId);
        Artists artist = this.artistService.getArtistById(Integer.parseInt(artistId));
//        Artists artist = new Artists();
//        artist.setPhoto("art.jpg");

        if(artist == null){
            return ResponseEntity.notFound().build();
        }
        Resource image = this.artistService.loadImage(artist);

        if(image==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;name="+image.getFilename()).body(image);
    }

//    @CrossOrigin(origins = "*")
    //register
    @PostMapping (path= "/register",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public String registerArtist(@RequestParam MultipartFile file, @RequestParam String about,
                                 @RequestParam String name, @RequestParam String email, @RequestParam String password,
                                 @RequestParam String number, @RequestParam String website){

        Register artists = new Register();
        artists.setAbout(about);
        artists.setEmail(email);
        artists.setName(name);
        artists.setNumber(number);
        artists.setWebsite(website);
        artists.setPassword(password);

        String status = this.artistService.registerArtist(artists);

        if(status.equals("not")) return "USERNAME ALREADY EXISTS";
        Artists artists1 = this.artistService.getArtistByEmail(email);
        String file_name = this.artistService.uploadImage(file, artists1);
        if (file_name == null) {
            return null;
        }
        artists1.setPhoto(file_name);
        this.artistService.updateArtist(artists1);

        return "ok";
    }



//    // Upload artist images
////    @CrossOrigin(origins="http://localhost:3000")
//    @PostMapping(value = "/artists/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String uploadDocument(@RequestParam MultipartFile file, @RequestParam int artistId) {
//        Artists artist = this.artistService.getArtistById(artistId);
//        return "ok";
//    }


}
