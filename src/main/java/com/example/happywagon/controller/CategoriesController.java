package com.example.happywagon.controller;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Categories;
import com.example.happywagon.bean.Products;
import com.example.happywagon.services.CategoriesService;
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

@CrossOrigin(origins="*")
@RestController
public class CategoriesController {

    Logger logger = LoggerFactory.getLogger(ArtistsController.class);
    @Autowired
    public CategoriesService categoryService;

    //add category
//    @PostMapping(path="/categories",consumes="application/JSON")
//    public Categories addCategory(@RequestBody Categories category){
//        logger.info("Adding a new category");
//        return this.categoryService.addCategory(category);}

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

    // Get category images
    @GetMapping(value = "/category/image/{categoryId}")
    public ResponseEntity<Resource> getCategoryImage(@PathVariable String categoryId) {
        System.out.println(categoryId);
        Categories category = this.categoryService.getCategoryById(Integer.parseInt(categoryId));

        if(category == null){
            return ResponseEntity.notFound().build();
        }
        Resource image = this.categoryService.loadImage(category);

        if(image==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;name="+image.getFilename()).body(image);
    }

    // add a new category
    @PostMapping(path="/categories",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Categories addCategory(@RequestParam MultipartFile file, @RequestParam String about,
                                  @RequestParam String name){

        Categories category = new Categories();
        category.setAbout(about);
        category.setName(name);

        logger.info("Adding a new category");


        Categories category1 =  this.categoryService.addCategory(category);

        String file_name = this.categoryService.uploadImage(file, category1);

        if (file_name == null) {
            return null;
        }

        category1.setPhoto(file_name);
        this.categoryService.updateCategory(category1);

        return category1;


    }

}
