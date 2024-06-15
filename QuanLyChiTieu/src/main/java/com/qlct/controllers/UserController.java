package com.qlct.controllers;

import com.qlct.pojo.Users;
import com.qlct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginsuccess")
    public String loginSuccess() {
        Users user = userService.getLoggedInUser();
        if ("ROLE_ADMIN".equals(user.getRole())) {
            return "redirect:/admin";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") Users user, Model model) {
        try {
            if (userService.addUser(user)) {
                return "redirect:/login";
            } else {
                model.addAttribute("error", "Registration failed. Please try again.");
                return "register";
            }
        } catch (Exception e) {
            // Log the error
            System.err.println("Error registering user: " + e.getMessage());
            model.addAttribute("error", "An error occurred during registration. Please try again later.");
            return "register";
        }
    }
}
