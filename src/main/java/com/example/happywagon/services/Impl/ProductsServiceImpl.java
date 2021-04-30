package com.example.happywagon.services.Impl;

import com.example.happywagon.JSONentity.Product;
import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Categories;
import com.example.happywagon.bean.Products;
import com.example.happywagon.dao.ArtistDao;
import com.example.happywagon.dao.CategoryDao;
import com.example.happywagon.dao.ProductDao;
import com.example.happywagon.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private CategoryDao categoryDao;

    public ProductsServiceImpl(){}

    @Override
    public Products addProduct(Product product) {
        Artists ar = artistDao.findById(product.getArt_id()).get();
        Categories cat = categoryDao.findById(product.getCate_id()).get();
        Products products = new Products(product.getName(),product.getDescription(), product.getPrice(),cat,ar,product.getPhoto());
        productDao.save(products);
        return products;
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
