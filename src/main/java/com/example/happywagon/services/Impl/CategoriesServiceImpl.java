package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Artists;
import com.example.happywagon.bean.Categories;
import com.example.happywagon.dao.CategoryDao;
import com.example.happywagon.services.CategoriesService;
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

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Value("${category_image_upload_location}")
    private String image_location;

    @Autowired
    private CategoryDao categoryDao;

    public CategoriesServiceImpl(){
    }

    @Override
    public Categories getCategoryById(Integer category_id){
        return categoryDao.findById(category_id).get();
    }


    @Override
    public List<Categories> getCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Categories addCategory(Categories category) {
        categoryDao.save(category);
        return category;
    }

    @Override
    public void deleteCategory(int categoryId) {
        Categories entity = categoryDao.getOne(categoryId);
        categoryDao.delete(entity);
    }

    @Override
    public Categories updateCategory(Categories category) {
        categoryDao.save(category);
        return category;
    }

    @Override
    public Resource loadImage(Categories category) {
        try {
            Path upload_location = Paths.get(image_location);
            Path file = upload_location.resolve(category.getPhoto());
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
    public String uploadImage(MultipartFile image, Categories category) {
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
            fileName = fileName + "_" + category.getCategory_id();
            Files.copy(inputStream, upload_location.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException error) {
            System.out.println("Error: [uploadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }


}

