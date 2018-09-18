package com.bloggertime.nowblog.services;

import com.bloggertime.nowblog.models.User;
import com.bloggertime.nowblog.models.UserWithRoles;
import com.bloggertime.nowblog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("We could not find user without username: " + username);
        }
        return new UserWithRoles(user);
    }

}
