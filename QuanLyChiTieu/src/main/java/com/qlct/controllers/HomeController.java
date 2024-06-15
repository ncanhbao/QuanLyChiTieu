/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlct.controllers;

import com.qlct.pojo.Users;
import com.qlct.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ncanh
 */
@CrossOrigin()
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        if (principal != null) {
            Users user = userService.getLoggedInUser();
            if (user != null && user.getRole().equals(Users.ADMIN)) {
                return "redirect:/admin";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
