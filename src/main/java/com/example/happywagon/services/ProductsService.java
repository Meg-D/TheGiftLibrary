package com.example.happywagon.services;
import com.example.happywagon.bean.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    public Products addProduct(Products product);
    public void deleteProduct(int product_id);
    public Optional<Products> getProductsByCategory(int category_id);
    public Optional<Products> getProductsByArtist(int artist_id);
    public List<Products> getProducts();
}
