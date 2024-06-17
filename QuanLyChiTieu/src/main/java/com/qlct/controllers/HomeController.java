package com.qlct.controllers;

import com.qlct.pojo.Users;
import com.qlct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        Users user = userService.getLoggedInUser();
        if (user != null) {
            if (user.getRole().equals(Users.ADMIN)) {
                return "redirect:/admin";
            } else {
                return "home";
            }
        } else {
            // Handle the case where the user is not logged in
            model.addAttribute("error", "Bạn phải đăng nhập để sử dụng tính năng này.");
            return "login";
        }
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        Users user = userService.getLoggedInUser();
        if (user != null) {
            if (user.getRole().equals(Users.ADMIN)) {
                return "redirect:/admin";
            } else {
                return "home";
            }
        } else {
            // Handle the case where the user is not logged in
            return "redirect:/login";
        }
    }
}
