package com.qlct.service;

import com.qlct.pojo.Transactions;

import java.util.List;

public interface TransactionService {
    List<Transactions> getTransactions(int page, int pageSize);
    int countTransactions();
    boolean addTransactions(Transactions transaction);
}
