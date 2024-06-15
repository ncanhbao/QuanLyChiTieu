package com.qlct.repository.impl;

import com.qlct.pojo.Igroups;
import com.qlct.repository.GroupRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Igroups> getGroups() {
        Session session = this.factory.getObject().getCurrentSession();
        return session.createQuery("FROM Igroups", Igroups.class).getResultList();
    }
}
