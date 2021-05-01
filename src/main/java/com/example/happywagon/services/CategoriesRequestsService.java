package com.example.happywagon.services;

import com.example.happywagon.bean.Category_Request;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoriesRequestsService {
    public Category_Request addCategoryRequest(Category_Request category_request);
    
    public void deleteCategoryRequest(int request_id);

    public List<Category_Request> getCategoriesRequests();
}
