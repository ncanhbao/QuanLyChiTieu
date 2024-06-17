package com.qlct.service;

import com.qlct.pojo.Users;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean addUser(Users user);
    List<Users> getUsers(String username);
    Users getLoggedInUser();
    boolean authUser(String username, String password);
    Users getUserByUsername(String name);
    boolean updateUser(Users user);
    boolean deleteUser(Users user);
    Users getUserById(int id);
}
