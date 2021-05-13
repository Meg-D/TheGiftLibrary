package com.example.happywagon.services;
import com.example.happywagon.JSONentity.Product;
import com.example.happywagon.bean.Products;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    public Products addProduct(Product product);
    public void deleteProduct(int product_id);
    public List<Products> getProductsByCategory(int category_id);
    public List<Products> getProductsByArtist(String email);
    public List<Products> getProducts();
    Products getProductById(int product_id);
    public Resource loadImage(Products products);
}
