package com.qlct.repository;

import com.qlct.pojo.Transactions;

import java.util.List;

public interface TransactionRepository {
    List<Transactions> getTransactions(int page, int pageSize);
    int countTransactions();
    boolean addTransactions(Transactions transaction);
}
