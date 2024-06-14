/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlct.repository.impl;

import com.qlct.pojo.Users;
import com.qlct.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ncanh
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;


    @Override
    public int addUser(Users user) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            int id = (Integer) session.save(user);
            return id;
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return 0;
        }
    }

    @Override
    public List<Users> getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder(); 
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root root = query.from(Users.class);
        query = query.select(root);
        
        if (!username.isEmpty())
        {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Users getUserByUsername(String string) {
         try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            Query q = s.createQuery("FROM Users WHERE username = :username");
            q.setParameter("username", sessionFactory);
            return (Users) q.getSingleResult();
        } catch (HibernateException e) {
            System.err.print(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean authUser(String username, String password) {
        Users u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());
    }
    
}
