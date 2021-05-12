package com.example.happywagon.controller;

import com.example.happywagon.JSONentity.Product;
import com.example.happywagon.bean.Products;
import com.example.happywagon.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class ProductsController {

    Logger logger = LoggerFactory.getLogger(ArtistsController.class);

    @Autowired
    public ProductsService productService;

    //get all products
    @GetMapping("/products")
    public List<Products> getProducts(){
        // System.out.println("inside controller");
        logger.info("getting all the products");
        return this.productService.getProducts();
    }

    //get product by id
    @GetMapping("/products/{product_id")
    public Products getProductById(@PathVariable String product_id){
        logger.info("getting a product of id: "+product_id);
        return this.productService.getProductById(Integer.parseInt(product_id));
    }

    //get all products by category
    @GetMapping("/productsCate/{category_id}")
    public List<Products> getProductsByCategory(@PathVariable String category_id){
        // System.out.println("inside controller");
        logger.info("getting all products of category id: "+category_id);
        return this.productService.getProductsByCategory(Integer.parseInt(category_id));
    }

    //get all products by artist
    @GetMapping("/productsArt/{artist_id}")
    public List<Products> getProductsByArtist(@PathVariable String artist_id){
        // System.out.println("inside controller");
        logger.info("getting all the products of artist id: "+artist_id);
        return this.productService.getProductsByArtist(Integer.parseInt(artist_id));
    }

    //add product
    @PostMapping(path="/products",consumes = "application/JSON")
    public Products addProduct(@RequestBody Product product){
        logger.info("adding a new product");
        return this.productService.addProduct(product);
    }

    //delete product
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId){
        try{
            logger.info("deleting a product with id: "+ productId);
            this.productService.deleteProduct(Integer.parseInt(productId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
