package com.bloggertime.nowblog.controller;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class UserController {

    private Roles roles;

    @Autowired
    public UsersController(
            UsersRepository usersDao,
            PasswordEncoder passwordEncoder,
            Roles roles
    ) {
        /* ... */
        this.roles = roles;
    }

    /* ... */
    private void authenticate(SecurityProperties.User user) {
        // Since we're using roles we need to retrieve them from the database
        // The rest of the method does not need changes
        UserDetails userDetails = new UserWithRoles(user, roles.ofUserWith(user.getUsername());
        /* ... */
    }
}
