package com.example.webapp.dao;

import com.example.webapp.entity.User;

public interface UserDAO {
    User getUser(int id);
    User findByEmail(String email);
    void saveUser(User user);
    void saveCurrentUser(User user);
}
