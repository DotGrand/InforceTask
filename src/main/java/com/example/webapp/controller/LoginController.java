package com.example.webapp.controller;

import com.example.webapp.entity.User;
import com.example.webapp.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login-page";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {

        return "access-denied";
    }
}
