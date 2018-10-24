package com.bloggertime.nowblog.repositories;


import com.bloggertime.nowblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Users extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
