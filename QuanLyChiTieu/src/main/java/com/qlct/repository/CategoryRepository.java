package com.qlct.repository;

import com.qlct.pojo.Categories;

import java.util.List;

public interface CategoryRepository {
    List<Categories> getCategories();
    Categories getCategoryById(int id);
}
