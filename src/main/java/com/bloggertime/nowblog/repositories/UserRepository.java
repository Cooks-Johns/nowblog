package com.bloggertime.nowblog.repositories;

import com.bloggertime.nowblog.models.Post;
import com.bloggertime.nowblog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findAll();
    User findByUserName(String username);
    User findById(long id);
    List <Post> findAllByOwner_ID(long id);



}
