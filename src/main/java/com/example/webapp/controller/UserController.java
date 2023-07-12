package com.example.webapp.controller;

import com.example.webapp.entity.User;

import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/show")
    public String showProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userService.findByEmail(email);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "profile";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        String email = user.getEmail();
        if (bindingResult.hasErrors()) {

            return "profile-save-form";
        } else {
            userService.saveCurrentUser(user);
            return "redirect:/profile/show";
        }
    }

    @GetMapping("/update")
    public String updateUserProfile(@RequestParam("userId") @Valid int id, Model model) {
        User user = userService.getUser(id);

        model.addAttribute("user", user);
        return "profile-save-form";
    }

}
