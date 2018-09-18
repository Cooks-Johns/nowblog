package com.bloggertime.nowblog.controller;


import com.bloggertime.nowblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private UserRepository users;
    private PasswordEncoder passwordEncoder;

    public HomeController(UserRepository users, )

   @GetMapping("/home")
    public String hello() {
       return "home";
   }


}