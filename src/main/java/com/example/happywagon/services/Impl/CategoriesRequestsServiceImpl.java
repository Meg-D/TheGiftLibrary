package com.example.happywagon.services.Impl;

import com.example.happywagon.bean.Category_Request;
import com.example.happywagon.dao.CategoryRequestDao;
import com.example.happywagon.services.CategoriesRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesRequestsServiceImpl implements CategoriesRequestsService {

    @Autowired
    private CategoryRequestDao categoryRequestDao;

    public CategoriesRequestsServiceImpl(){
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

}
