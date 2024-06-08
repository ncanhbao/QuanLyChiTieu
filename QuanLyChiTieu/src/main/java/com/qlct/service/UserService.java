/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlct.service;

import com.qlct.pojo.Users;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ncanh
 */
public interface UserService extends UserDetailsService{
    boolean addUser (Users user);
    List<Users> getUsers (String username);
}
