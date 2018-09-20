package com.bloggertime.nowblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm() {

        return "users/login";
    }

}
