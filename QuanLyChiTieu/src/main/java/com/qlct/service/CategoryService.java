package com.qlct.service;

import com.qlct.pojo.Categories;

import java.util.List;

public interface CategoryService {
    List<Categories> getCategories();
    Categories getCategoryById(int id);
}
