package com.qlct.controllers;

import com.qlct.pojo.Users;
import com.qlct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        try {
            List<Users> users = userService.getUsers("");
            model.addAttribute("users", users);
            return "admin-users";
        } catch (Exception e) {
            // Log the error
            System.err.println("Error getting users: " + e.getMessage());
            model.addAttribute("error", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
            return "admin-users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        try {
            Users user = userService.getUserById(id);
            if (user != null) {
                if (userService.deleteUser(user)) {
                    model.addAttribute("success", "Xóa tài khoản thành công.");
                } else {
                    model.addAttribute("error", "Xóa tài khoản không thành công. Vui lòng thử lại.");
                }
            } else {
                model.addAttribute("error", "Không tìm thấy tài khoản.");
            }
            return "redirect:/admin/users";
        } catch (Exception e) {
            // Log the error
            System.err.println("Error deleting user: " + e.getMessage());
            model.addAttribute("error", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
            return "redirect:/admin/users";
        }
    }

    @GetMapping("/users/disable/{id}")
    public String disableUser(@PathVariable("id") int id, Model model) {
        try {
            Users user = userService.getUserById(id);
            if (user != null) {
                user.setIsActive(0); // Set isActive to 0 to disable the user
                if (userService.updateUser(user)) {
                    model.addAttribute("success", "Vô hiệu hóa tài khoản thành công.");
                } else {
                    model.addAttribute("error", "Vô hiệu hóa tài khoản không thành công. Vui lòng thử lại.");
                }
            } else {
                model.addAttribute("error", "Không tìm thấy tài khoản.");
            }
            return "redirect:/admin/users";
        } catch (Exception e) {
            // Log the error
            System.err.println("Error disabling user: " + e.getMessage());
            model.addAttribute("error", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
            return "redirect:/admin/users";
        }
    }
}
