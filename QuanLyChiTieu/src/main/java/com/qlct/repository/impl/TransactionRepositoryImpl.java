package com.qlct.repository.impl;

import com.qlct.pojo.Transactions;
import com.qlct.repository.TransactionRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Transactions> getTransactions() {
        Session session = this.factory.getObject().getCurrentSession();
        return session.createQuery("FROM Transactions", Transactions.class).getResultList();
    }

    @Override
    public boolean addTransactions(Transactions transaction) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            session.save(transaction);
            return true;
        } catch (HibernateException ex) {
            System.err.println("Error adding transaction: " + ex.getMessage());
            return false;
        }
    }
}
