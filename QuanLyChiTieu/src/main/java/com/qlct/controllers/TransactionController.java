

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlct.controllers;

import com.qlct.pojo.Transactions;
import com.qlct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ncanh
 */
@Controller
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    
    @GetMapping
    public String listTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getTransactions());
        return "transaction-list"; // Tên view hiển thị danh sách giao dịch
    }
    
    @GetMapping("/add")
    public String addTransactionView(Model model) {
        model.addAttribute("transaction", new Transactions());
        return "transaction-add"; // Tên view để thêm giao dịch mới
    }
    
     @PostMapping("/add")
    public String addTransaction(@ModelAttribute("transaction") Transactions transaction) {
        if (transactionService.addTransactions(transaction)) {
            return "redirect:/transactions"; // Chuyển hướng về trang danh sách giao dịch sau khi thêm thành công
        } else {
            // Xử lý trường hợp thêm giao dịch thất bại
            return "transaction-add"; // Quay lại trang thêm giao dịch
        }
    }
}
