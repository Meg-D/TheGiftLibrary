package com.example.happywagon.services;

import com.example.happywagon.bean.Categories;
import com.example.happywagon.bean.Category_Request;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoriesRequestsService {
    public Category_Request addCategoryRequest(Category_Request category_request);
    
    public void deleteCategoryRequest(int request_id);

    public List<Category_Request> getCategoriesRequests();

    public String uploadImage(MultipartFile file, Category_Request category_request);

    public Category_Request updateCategoryRequest(Category_Request category_request);

    public Category_Request getCategoryRequestById(Integer request_id);

    public Resource loadImage(Category_Request category_request);
}
