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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Value("${product_image_upload_location}")
    private String image_location;

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
        Products products = new Products(product.getProduct_id(),product.getName(),product.getDescription(), product.getPrice(),cat,ar,product.getPhoto());
        productDao.save(products);
        return products;
    }

    @Override
    public void deleteProduct(int product_id) {
        Products entity = productDao.getOne(product_id);
        productDao.delete(entity);
    }

    @Override
    public List<Products> getProductsByCategory(int category_id) {
        Categories category = categoryDao.findById(category_id).get();
        return productDao.getProductsByCategory(category);
    }

    @Override
    public List<Products> getProductsByArtist(String email) {
        Artists art =artistDao.getArtistByEmail(email);
        Integer artist_id = art.getArtist_id();
        Artists artist = artistDao.findById(artist_id).get();
        return productDao.getProductsByArtist(artist);
    }

    @Override
    public List<Products> getProducts() {
        return productDao.findAll();
    }

    @Override
    public Products getProductById(int product_id) {
        return productDao.findById(product_id).get();
    }


    @Override
    public Resource loadImage(Products products) {
        try {
            Path upload_location = Paths.get(image_location);
            Path file = upload_location.resolve(products.getPhoto());
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException error) {
            System.out.println("Error: [loadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void updateProduct(Products product) {
        productDao.save(product);
//        return product;
    }

//    @Override
//    public String uploadImage(MultipartFile file, Products product) {
//        return null;
//    }

    @Override
    public String uploadImage(MultipartFile image, Products product) {
        if (image.getOriginalFilename() == null) {
            return null;
        }
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        if (image.isEmpty()) {
            return null;
        }
        if (fileName.contains("..")) {
            fileName = fileName.replace("..", "_");
        }
        try (InputStream inputStream = image.getInputStream()) {
            Path upload_location = Paths.get(image_location);
            fileName = fileName + "_" + product.getProduct_id();
            Files.copy(inputStream, upload_location.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException error) {
            System.out.println("Error: [uploadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }
}
