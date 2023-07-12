package com.example.webapp.service;


import com.example.webapp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getUser(int id);

    User findByEmail(String email);

    void save(User user);

    void saveCurrentUser(User user);
}
