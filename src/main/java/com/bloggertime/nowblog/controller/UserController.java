package com.bloggertime.nowblog.controller;


import com.bloggertime.nowblog.models.Post;
import com.bloggertime.nowblog.models.User;
import com.bloggertime.nowblog.models.UserWithRoles;
import com.bloggertime.nowblog.repositories.PostRepository;
import com.bloggertime.nowblog.repositories.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PostRepository postService;


    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, PostRepository postService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.postService = postService;

    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new SecurityProperties.User());
        return "usersRepository/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        return "redirect:/login";
    }


    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable long id, Model view) {
        view.addAttribute("user", userRepository.findUsersById(id));
        List<Post> postList = postService.findAllByOwner_ID(id);
        view.addAttribute("posts", postList);
        return "users/profile";
    }

}
