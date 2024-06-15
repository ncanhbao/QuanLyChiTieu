package com.qlct.service.impl;

import com.qlct.pojo.Transactions;
import com.qlct.repository.TransactionRepository;
import com.qlct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean addTransactions(Transactions transaction) {
        return this.transactionRepo.addTransactions(transaction);
    }
}
