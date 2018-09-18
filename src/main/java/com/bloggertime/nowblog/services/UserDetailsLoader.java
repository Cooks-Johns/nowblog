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

    private final User users;

    public UserDetailsLoader(User users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = users.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("We could not find user without username: " + userName);
        }
        return new UserWithRoles(user);
    }

}
