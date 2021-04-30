package com.example.happywagon.controller;

import com.example.happywagon.bean.Category_Request;
import com.example.happywagon.services.CategoriesRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesRequestsController {

    @Autowired
    CategoriesRequestsService categoriesRequestsService;

    //add category
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path="/crequests",consumes="application/JSON")
    public Category_Request addCategory_Request(@RequestBody Category_Request category_request){
        return this.categoriesRequestsService.addCategoryRequest(category_request);}

    //delete request
    @CrossOrigin(origins="http://localhost:3000")
    @DeleteMapping("/crequest/{requestId}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable String requestId){
        try{
            this.categoriesRequestsService.deleteCategoryRequest(Integer.parseInt(requestId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all the requests
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/crequests")
    public List<Category_Request> getRequests(){
        // System.out.println("inside controller");
        return this.categoriesRequestsService.getCategoriesRequests();
    }
}
