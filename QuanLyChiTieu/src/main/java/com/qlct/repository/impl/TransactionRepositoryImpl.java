package com.qlct.repository.impl;

import com.qlct.pojo.Transactions;
import com.qlct.repository.TransactionRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
    public List<Transactions> getTransactions(int page, int pageSize) {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            Query<Transactions> query = session.createQuery("FROM Transactions", Transactions.class);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } catch (HibernateException ex) {
            System.err.println("Error getting transactions: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int countTransactions() {
        try {
            Session session = this.factory.getObject().getCurrentSession();
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Transactions", Long.class);
            return query.getSingleResult().intValue();
        } catch (HibernateException ex) {
            System.err.println("Error counting transactions: " + ex.getMessage());
            return 0;
        }
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
