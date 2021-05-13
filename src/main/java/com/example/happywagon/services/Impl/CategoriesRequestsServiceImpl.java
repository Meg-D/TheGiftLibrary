package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Categories;
import com.example.happywagon.bean.Category_Request;
import com.example.happywagon.dao.CategoryRequestDao;
import com.example.happywagon.services.CategoriesRequestsService;
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
public class CategoriesRequestsServiceImpl implements CategoriesRequestsService {

    @Value("${categoryRequest_image_upload_location}")
    private String image_location;

    @Autowired
    private CategoryRequestDao categoryRequestDao;

    public CategoriesRequestsServiceImpl(){
    }

    @Override
    public Category_Request getCategoryRequestById(Integer request_id){
        return categoryRequestDao.findById(request_id).get();
    }

    @Override
    public Category_Request addCategoryRequest(Category_Request category_request) {
        categoryRequestDao.save(category_request);
        return category_request;
    }

    @Override
    public void deleteCategoryRequest(int request_id) {
        Category_Request entity = categoryRequestDao.getOne(request_id);
        categoryRequestDao.delete(entity);
    }

    @Override
    public List<Category_Request> getCategoriesRequests() {
        return categoryRequestDao.findAll();
    }


    @Override
    public Category_Request updateCategoryRequest(Category_Request category_request) {
        categoryRequestDao.save(category_request);
        return category_request;
    }

    @Override
    public String uploadImage(MultipartFile image, Category_Request category_request) {
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
            fileName = fileName + "_" + category_request.getRequest_id();
            Files.copy(inputStream, upload_location.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException error) {
            System.out.println("Error: [uploadImage][ArtistsServiceImpl] " + error.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Resource loadImage(Category_Request category_request) {
        try {
            Path upload_location = Paths.get(image_location);
            Path file = upload_location.resolve(category_request.getPhoto());
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

}
