package com.example.happywagon.services;

import com.example.happywagon.bean.Categories;

import java.util.List;

public interface CategoriesService {
    public List<Categories> getCategories();

    public Categories addCategory(Categories category);

    public void deleteCategory(int categoryId);
}
