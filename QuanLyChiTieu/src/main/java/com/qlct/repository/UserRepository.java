/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qlct.repository;

import com.qlct.pojo.Users;
import java.util.List;

/**
 *
 * @author ncanh
 */
public interface UserRepository {
    int addUser(Users user);
    List<Users> getUsers(String username);
    Users getUserByUsername(String username);
    boolean authUser(String username, String password);
}
