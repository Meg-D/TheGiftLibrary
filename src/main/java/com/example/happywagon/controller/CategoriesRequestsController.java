package com.example.happywagon.controller;

import com.example.happywagon.bean.Category_Request;
import com.example.happywagon.services.CategoriesRequestsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class CategoriesRequestsController {

    Logger logger = LoggerFactory.getLogger(ArtistsController.class);

    @Autowired
    CategoriesRequestsService categoriesRequestsService;

    //add category
    @PostMapping(path="/crequests",consumes="application/JSON")
    public Category_Request addCategory_Request(@RequestBody Category_Request category_request){
        logger.info("adding a category request");
        return this.categoriesRequestsService.addCategoryRequest(category_request);}

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
}
