package com.bloggertime.nowblog.repositories;

import com.bloggertime.nowblog.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    static void search(Post post) {

    }

    List <Post> findAll();

    Post findById(long id);

    List <Post> findAllByOwner_ID(long id);

    }