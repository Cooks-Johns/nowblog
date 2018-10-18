package com.bloggertime.nowblog.services;


import com.bloggertime.nowblog.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserServices extends UserDetailsService {

   User findbyUsername(String username);
}
