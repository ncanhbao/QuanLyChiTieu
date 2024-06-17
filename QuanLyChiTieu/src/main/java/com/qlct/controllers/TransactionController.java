package com.qlct.controllers;

import com.qlct.pojo.Transactions;
import com.qlct.pojo.Users;
import com.qlct.service.CategoryService;
import com.qlct.service.TransactionService;
import com.qlct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping("/transaction-list")
    public String listTransactions(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            Model model) {
        Users user = userService.getLoggedInUser();
        if (user != null) {
            model.addAttribute("transactions", transactionService.getTransactions(page, pageSize));
            int totalTransactions = transactionService.countTransactions();
            int totalPages = (totalTransactions + pageSize - 1) / pageSize;
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("pageSizes", new int[]{10, 20, 50, 100});
            model.addAttribute("selectedPageSize", pageSize);
            return "transaction-list";
        } else {
            // Handle the case where the user is not logged in
            model.addAttribute("error", "Bạn phải đăng nhập để sử dụng tính năng này.");
            return "login";
        }
    }

    @GetMapping("/transaction-add")
    public String addTransactionView(Model model) {
        Users user = userService.getLoggedInUser();
        if (user != null) {
            model.addAttribute("transaction", new Transactions());
            model.addAttribute("categories", categoryService.getCategories());
            return "transaction-add";
        } else {
            // Handle the case where the user is not logged in
            model.addAttribute("error", "Bạn phải đăng nhập để sử dụng tính năng này.");
            return "login";
        }
    }

    @PostMapping("/transaction-add")
    public String addTransaction(@Valid @ModelAttribute("transaction") Transactions transaction, BindingResult bindingResult, Model model) {
        Users user = userService.getLoggedInUser();
        if (user != null) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("categories", categoryService.getCategories());
                return "transaction-add";
            }

            try {
                transaction.setUserId(user);
                transaction.setCategoryId(categoryService.getCategoryById(transaction.getCategoryId().getId()));
                if (transactionService.addTransactions(transaction)) {
                    return "redirect:/transaction-list";
                } else {
                    model.addAttribute("error", "Thêm giao dịch không thành công. Vui lòng thử lại.");
                    model.addAttribute("categories", categoryService.getCategories());
                    return "transaction-add";
                }
            } catch (Exception e) {
                // Log the error
                System.err.println("Error adding transaction: " + e.getMessage());
                model.addAttribute("error", "Đã có lỗi xảy ra trong quá trình thêm giao dịch. Vui lòng thử lại sau.");
                model.addAttribute("categories", categoryService.getCategories());
                return "transaction-add";
            }
        } else {
            // Handle the case where the user is not logged in
            model.addAttribute("error", "Bạn phải đăng nhập để sử dụng tính năng này.");
            return "login";
        }
    }
}
