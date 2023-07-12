package com.example.webapp.controller;

import com.example.webapp.entity.User;

import com.example.webapp.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(RegistrationController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult theBindingResult,
            Model model) {

        String email = user.getEmail();
        logger.info("Processing registration form for: " + email);

        if (theBindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            for (FieldError fieldError : theBindingResult.getFieldErrors()) {
                if (map.put(fieldError.getField(), fieldError.getDefaultMessage()) != null) {
                    throw new IllegalStateException("Duplicate key");
                }
            }
            model.addAttribute("errors", map);
            return "registration";
        }

        // check the database if user already exists
        User existing = userService.findByEmail(email);
        if (existing != null) {
            model.addAttribute("user", new User());
            model.addAttribute("registrationError", "Email already exists.");

            logger.warn("Email already exists.");
            return "registration";
        }

        userService.save(user);
        logger.info("Successfully created user: " + email);

        return "login-page";
    }
}
