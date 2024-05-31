/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlct.repository.impl;

import com.qlct.pojo.Transactions;
import com.qlct.repository.TransactionRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ncanh
 */
@Repository
@Transactional
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Transactions> getTransactions() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Transactions");
        return q.getResultList();
    }

    @Override
    public boolean addTransactions(Transactions transaction) {
          try {
            Session session = this.factory.getObject().getCurrentSession();
            session.save(transaction);
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

}
