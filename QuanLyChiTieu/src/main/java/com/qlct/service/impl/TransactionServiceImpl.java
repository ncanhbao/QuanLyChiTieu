package com.qlct.service.impl;

import com.qlct.pojo.Transactions;
import com.qlct.repository.TransactionRepository;
import com.qlct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Override
    public List<Transactions> getTransactions() {
        return this.transactionRepo.getTransactions();
    }

    @Override
    @Transactional
    public boolean addTransactions(Transactions transaction) {
        try {
            return this.transactionRepo.addTransactions(transaction);
        } catch (Exception e) {
            // Log the error
            System.err.println("Error adding transaction: " + e.getMessage());
            return false;
        }
    }
}
