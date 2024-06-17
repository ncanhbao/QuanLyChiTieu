package com.qlct.service.impl;

import com.qlct.pojo.Categories;
import com.qlct.repository.CategoryRepository;
import com.qlct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categories> getCategories() {
        return categoryRepository.getCategories();
    }

    @Override
    public Categories getCategoryById(int id) {
        return categoryRepository.getCategoryById(id);
    }
}
