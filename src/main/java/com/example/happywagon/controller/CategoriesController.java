package com.example.happywagon.controller;

import com.example.happywagon.bean.Categories;
import com.example.happywagon.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    public CategoriesService categoryService;

    //add category
    @PostMapping(path="/categories",consumes="application/JSON")
    public Categories addCategory(@RequestBody Categories category){ return this.categoryService.addCategory(category);}

    //get all the categories
    @GetMapping("/categories")
    public List<Categories> getCategories(){
        return this.categoryService.getCategories();
    }

    //delete category
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable String categoryId){
        try{
            this.categoryService.deleteCategory(Integer.parseInt(categoryId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
