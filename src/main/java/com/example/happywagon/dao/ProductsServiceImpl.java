package com.example.happywagon.dao;

import com.example.happywagon.bean.Products;
import com.example.happywagon.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductDao productDao;

    public ProductsServiceImpl(){}

    @Override
    public Products addProduct(Products product) {
        productDao.save(product);
        return product;
    }

    @Override
    public void deleteProduct(int product_id) {
        Products entity = productDao.getOne(product_id);
        productDao.delete(entity);
    }

    @Override
    public Optional<Products> getProductsByCategory(int category_id) {
        return productDao.findById(category_id);
    }

    @Override
    public Optional<Products> getProductsByArtist(int artist_id) {
        return productDao.findById(artist_id);
    }

    @Override
    public List<Products> getProducts() {
        return productDao.findAll();
    }
}
