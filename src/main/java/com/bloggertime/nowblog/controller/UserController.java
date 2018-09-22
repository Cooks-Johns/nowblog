package com.bloggertime.nowblog.controller;


import com.bloggertime.nowblog.models.User;

import com.bloggertime.nowblog.repositories.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;


    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;

    }

    @GetMapping("/users/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new SecurityProperties.User());
        return "users/register";
    }

    @PostMapping("/users/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        users.save(user);
//        users.save(user);
        return "redirect:/login";
    }


    @GetMapping("/users/profile/{id}")
    public String showProfile(@PathVariable long id, Model view) {
        User user = users.findOne(id);
//        List<Post> postList = postService.findAllByOwner_ID(id);
        view.addAttribute("user", user);
        return "users/profile";
    }

    // view logged-in users's profile
    @GetMapping("/users/profile")
    public String user(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user.getId() == 0) {
            return "redirect:/login";
        }

        user = users.findOne(user.getId());

        model.addAttribute("user", user);
        return "users/profile";
    }

}
