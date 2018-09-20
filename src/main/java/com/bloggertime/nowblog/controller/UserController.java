package com.bloggertime.nowblog.controller;


import com.bloggertime.nowblog.models.Post;
import com.bloggertime.nowblog.models.User;
import com.bloggertime.nowblog.models.UserWithRoles;
import com.bloggertime.nowblog.repositories.PostRepository;
import com.bloggertime.nowblog.repositories.UserRepository;
import com.bloggertime.nowblog.repositories.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserController(Users users, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    @GetMapping("/users/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new SecurityProperties.User());
        return "users/sign-up";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        userRepository.save(user);
//        users.save(user);
        return "redirect:/login";
    }


    @GetMapping("/users/profile/{id}")
    public String showProfile(@PathVariable long id, Model view) {
        User user = userRepository.findOne(id);
//        List<Post> postList = postService.findAllByOwner_ID(id);
        view.addAttribute("user", user);
        return "users/profile";
    }

}
