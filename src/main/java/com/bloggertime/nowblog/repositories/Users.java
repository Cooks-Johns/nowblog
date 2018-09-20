package com.bloggertime.nowblog.repositories;


import com.bloggertime.nowblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {

    User findUserByUsername(String username);


}
