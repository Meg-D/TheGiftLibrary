package com.example.happywagon.controller;

import com.example.happywagon.bean.Categories;
import com.example.happywagon.bean.Category_Request;
import com.example.happywagon.services.CategoriesRequestsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
public class CategoriesRequestsController {

    Logger logger = LoggerFactory.getLogger(ArtistsController.class);

    @Autowired
    CategoriesRequestsService categoriesRequestsService;

//    //add category
//    @PostMapping(path="/crequests",consumes="application/JSON")
//    public Category_Request addCategory_Request(@RequestBody Category_Request category_request){
//        logger.info("adding a category request");
//        return this.categoriesRequestsService.addCategoryRequest(category_request);}

    //delete request
    @DeleteMapping("/crequest/{requestId}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable String requestId){
        try{
            logger.info("deleting the category request with id: "+ requestId);
            this.categoriesRequestsService.deleteCategoryRequest(Integer.parseInt(requestId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all the requests
    @GetMapping("/crequests")
    public List<Category_Request> getRequests(){
        // System.out.println("inside controller");
        logger.info("getting all the category requests");
        return this.categoriesRequestsService.getCategoriesRequests();
    }

    // request a new category
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path="/crequests",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Category_Request addCategory(@RequestParam MultipartFile file, @RequestParam String about,
                                  @RequestParam String name){

        System.out.println("in");
        Category_Request category_request = new Category_Request();
        category_request.setAbout(about);
        category_request.setName(name);

        logger.info("Adding a category category");


        Category_Request cat =  this.categoriesRequestsService.addCategoryRequest(category_request);

        String file_name = this.categoriesRequestsService.uploadImage(file, cat);

        if (file_name == null) {
            return null;
        }

        cat.setPhoto(file_name);
        this.categoriesRequestsService.updateCategoryRequest(cat);

        return cat;


    }

    // Get category images
    @GetMapping(value = "/crequest/image/{requestId}")
    public ResponseEntity<Resource> getCategoryImage(@PathVariable String requestId) {
        System.out.println(requestId);
        Category_Request category_request = this.categoriesRequestsService.getCategoryRequestById(Integer.parseInt(requestId));

        if(category_request == null){
            return ResponseEntity.notFound().build();
        }
        Resource image = this.categoriesRequestsService.loadImage(category_request);

        if(image==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;name="+image.getFilename()).body(image);
    }

}
