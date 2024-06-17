package com.qlct.repository;

import com.qlct.pojo.Users;
import java.util.List;

public interface UserRepository {
    int addUser(Users user);
    List<Users> getUsers(String username);
    Users getUserByUsername(String username);
    boolean authUser(String username, String password);
    boolean updateUser(Users user);
    boolean deleteUser(Users user);
    Users getUserById(int id);
}
