package com.example.happywagon.services;

import com.example.happywagon.bean.Categories;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoriesService {
    public List<Categories> getCategories();

    public Categories addCategory(Categories category);
    public Categories getCategoryById(Integer category_id);

    public void deleteCategory(int categoryId);

    public Categories updateCategory(Categories category);

    public Resource loadImage(Categories category);

    public String uploadImage(MultipartFile file, Categories category);
}
