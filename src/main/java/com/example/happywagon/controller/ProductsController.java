package com.example.happywagon.controller;

import com.example.happywagon.JSONentity.Product;
import com.example.happywagon.bean.Products;
import com.example.happywagon.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    public ProductsService productService;

    //get all products
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/products")
    public List<Products> getProducts(){
        // System.out.println("inside controller");
        return this.productService.getProducts();
    }

    //get all products by category
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/productsCate/{category_id}")
    public Optional<Products> getProductsByCategory(@PathVariable String category_id){
        // System.out.println("inside controller");
        return this.productService.getProductsByCategory(Integer.parseInt(category_id));
    }

    //get all products by artist
    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/productsArt/{artist_id}")
    public Optional<Products> getProductsByArtist(@PathVariable String artist_id){
        // System.out.println("inside controller");
        return this.productService.getProductsByArtist(Integer.parseInt(artist_id));
    }

    //add product
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(path="/products",consumes = "application/JSON")
    public Products addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }

    //delete product
    @CrossOrigin(origins="http://localhost:3000")
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId){
        try{
            this.productService.deleteProduct(Integer.parseInt(productId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
