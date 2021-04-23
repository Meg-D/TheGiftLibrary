package com.example.happywagon.dao;

import com.example.happywagon.bean.Categories;
import com.example.happywagon.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoryDao categoryDao;

    public CategoriesServiceImpl(){

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
}
