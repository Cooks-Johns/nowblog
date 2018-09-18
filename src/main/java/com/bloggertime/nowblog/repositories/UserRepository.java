package com.bloggertime.nowblog.repositories;

import com.bloggertime.nowblog.models.User;

public class UserRepository {

    public interface Users extends CrudRepository<User, Long> {
        User findByUsername(String username);
    }
}
