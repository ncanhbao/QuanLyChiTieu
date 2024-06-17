package com.qlct.service.impl;

import com.qlct.pojo.Users;
import com.qlct.repository.UserRepository;
import com.qlct.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public boolean addUser(Users user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        user.setRole(Users.USER);
        try {
            int userId = this.userRepository.addUser(user);
            if (userId != 0) {
                int active = 1;
                user.setIsActive(active);
                return true;
            }
        } catch (HibernateException ex) {
            System.err.print(ex.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public List<Users> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist !");
        }
        Users user = users.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }

    @Override
    public Users getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            List<Users> users = userRepository.getUsers(username);
            if (users != null && !users.isEmpty()) {
                return users.get(0);
            }
        }
        return null;
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepository.authUser(username, password);
    }

    @Override
    public Users getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    @Transactional
    public boolean updateUser(Users user) {
        try {
            return this.userRepository.updateUser(user);
        } catch (Exception e) {
            System.err.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(Users user) {
        try {
            return this.userRepository.deleteUser(user);
        } catch (Exception e) {
            System.err.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Users getUserById(int id) {
        return this.userRepository.getUserById(id);
    }
}
