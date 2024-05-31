/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlct.service.impl;

import com.qlct.pojo.Transactions;
import com.qlct.repository.TransactionRepository;
import com.qlct.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncanh
 */
@Service
public class TransactionServiceImpl implements TransactionService{

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
