package com.example.happywagon.controller;

import com.example.happywagon.bean.Categories;
import com.example.happywagon.services.CategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class CategoriesController {

    Logger logger = LoggerFactory.getLogger(ArtistsController.class);
    @Autowired
    public CategoriesService categoryService;

    //add category
    @PostMapping(path="/categories",consumes="application/JSON")
    public Categories addCategory(@RequestBody Categories category){
        logger.info("Adding a new category");
        return this.categoryService.addCategory(category);}

    //get all the categories
    @GetMapping("/categories")
    public List<Categories> getCategories(){
        logger.info("getting all the categories");
        return this.categoryService.getCategories();
    }

    //delete category
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable String categoryId){
        try{
            logger.info("deleting a category with id: "+ categoryId);
            this.categoryService.deleteCategory(Integer.parseInt(categoryId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update category
    @PutMapping("/categories")
    public Categories updateCategory(@RequestBody Categories category){
        return this.categoryService.updateCategory(category);
    }

}
