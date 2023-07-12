package com.example.webapp.service;


import com.example.webapp.dao.UserDAO;
import com.example.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public void save(User user) {
        User theUser = new User();

        theUser.setEmail(user.getEmail());
        theUser.setPassword(passwordEncoder.encode(user.getPassword()));
        theUser.setUserName(user.getUserName());

        userDAO.saveUser(theUser);
    }

    @Override
    public void saveCurrentUser(User user) {
        userDAO.saveCurrentUser(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
