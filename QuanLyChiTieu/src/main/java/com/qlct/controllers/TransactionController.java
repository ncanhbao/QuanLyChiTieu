package com.qlct.controllers;

import com.qlct.pojo.Categories;
import com.qlct.pojo.Igroups;
import com.qlct.pojo.Transactions;
import com.qlct.service.CategoryService;
import com.qlct.service.GroupService;
import com.qlct.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/transaction-list")
    public String listTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getTransactions());
        return "transaction-list";
    }

    @GetMapping("/transaction-add")
    public String addTransactionView(Model model) {
        model.addAttribute("transaction", new Transactions());
        model.addAttribute("categories", categoryService.getCategories());
        return "transaction-add";
    }

    @PostMapping("/transaction-add")
    public String addTransaction(@Valid @ModelAttribute("transaction") Transactions transaction, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getCategories());
            return "transaction-add";
        }

        if (transactionService.addTransactions(transaction)) {
            return "redirect:/transaction-list";
        } else {
            model.addAttribute("error", "Thêm giao dịch không thành công. Vui lòng thử lại.");
            model.addAttribute("categories", categoryService.getCategories());
            return "transaction-add";
        }
    }
}