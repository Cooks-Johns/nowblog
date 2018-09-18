package com.bloggertime.nowblog.controller;

import com.bloggertime.nowblog.models.Post;
import com.bloggertime.nowblog.repositories.UserRepository;
import com.bloggertime.nowblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final UserRepository userRepository;

    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/post/list")
    public String index(Model view) {

        List<Post> post;
        post = postService.findAll();
        view.addAttribute("post", post);
        return "posts/list";
    }

    @GetMapping("/post/create")
    public String create(Model view) { // check it out
        view.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/post/create")
    public String savePost(@ModelAttribute Post post, Errors errors){
        for (ObjectError objectError : errors.getAllErrors()) {
            System.out.println(objectError);
        }
        postService.save(post);
        return "redirect:/dash";
    }




    @GetMapping("/postfound")
    public String showFind() {
        return "geocaches/found";
    }



    @GetMapping("/post/{id}")
    public String show(@PathVariable long id, Model view) {
        Post post = postService.findById(id);
        view.addAttribute("post", post);
        return "post/show";
    }

    @GetMapping("/post{id}/edit")
    public String edit(@PathVariable long id, Model view) {
        Post post = postService.findById(id);
        view.addAttribute("post", post);
        return "post/edit";
    }

    @PostMapping("/post/{id}/edit")
    public String updateGeo(@PathVariable long id, @ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/dash";

    }

}

