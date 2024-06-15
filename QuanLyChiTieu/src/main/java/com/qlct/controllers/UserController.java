package com.qlct.controllers;

import com.qlct.pojo.Users;
import com.qlct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginsuccess")
    public String loginSuccess(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            Users user = userService.getLoggedInUser();
            if (user != null && user.getRole().equals(Users.ADMIN)) {
                return "redirect:/admin";
            } else {
                return "redirect:/home";
            }
        }
        return "redirect:/login";
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
                model.addAttribute("success", "Đăng ký thành công!");
                return "redirect:/login";
            } else {
                model.addAttribute("error", "Đăng ký không thành công. Vui lòng thử lại.");
                return "register";
            }
        } catch (Exception e) {
            // Log the error
            System.err.println("Error registering user: " + e.getMessage());
            model.addAttribute("error", "Đã có lỗi xảy ra trong quá trình đăng ký. Vui lòng thử lại sau.");
            return "register";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/"; // Redirect to the index page after logout
    }
}
