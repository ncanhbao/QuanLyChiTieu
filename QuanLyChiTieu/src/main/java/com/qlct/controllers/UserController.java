package com.qlct.controllers;

import com.qlct.pojo.Users;
import com.qlct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

    @GetMapping("/account")
    public String accountView(Model model) {
        Users user = userService.getLoggedInUser();
        if (user != null) {
            model.addAttribute("user", user);
            return "account";
        } else {
            model.addAttribute("error", "Bạn phải đăng nhập để truy cập trang này.");
            return "login";
        }
    }

    @PostMapping("/account")
    public String updateAccount(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult, Model model) {
        Users loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            if (bindingResult.hasErrors()) {
                return "account";
            }
            try {
                loggedInUser.setName(user.getName());
                loggedInUser.setPhone(user.getPhone());
                loggedInUser.setAvatar(user.getAvatar());
                if (userService.updateUser(loggedInUser)) {
                    model.addAttribute("success", "Cập nhật thông tin tài khoản thành công.");
                } else {
                    model.addAttribute("error", "Đã có lỗi xảy ra trong quá trình cập nhật thông tin. Vui lòng thử lại sau.");
                }
                return "account";
            } catch (Exception e) {
                System.err.println("Error updating user: " + e.getMessage());
                model.addAttribute("error", "Đã có lỗi xảy ra trong quá trình cập nhật thông tin. Vui lòng thử lại sau.");
                return "account";
            }
        } else {
            model.addAttribute("error", "Bạn phải đăng nhập để truy cập trang này.");
            return "login";
        }
    }
}
