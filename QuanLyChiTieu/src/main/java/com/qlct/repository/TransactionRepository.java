/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlct.repository;

import com.qlct.pojo.Transactions;
import java.util.List;

/**
 *
 * @author ncanh
 */
public interface TransactionRepository {
    List<Transactions> getTransactions();
    boolean addTransactions(Transactions transaction);
}
