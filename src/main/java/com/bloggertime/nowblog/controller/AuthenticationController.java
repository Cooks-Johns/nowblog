package com.bloggertime.nowblog.controller;

import com.bloggertime.nowblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm() {

        User user = new User();


        return "/users/login";
    }

}
