package com.qlct.repository.impl;

import com.qlct.pojo.Categories;
import com.qlct.repository.CategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Categories> getCategories() {
        Session session = this.factory.getObject().getCurrentSession();
        return session.createQuery("FROM Categories", Categories.class).getResultList();
    }

    @Override
    public Categories getCategoryById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Categories.class, id);
    }
}
