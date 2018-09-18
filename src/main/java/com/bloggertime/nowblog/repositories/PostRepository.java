package com.bloggertime.nowblog.repositories;

import com.bloggertime.nowblog.models.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    static void search(Posts posts) {

    }
    List<Post> findAll();

    Post findById(long id);
    List<Post> findAllByOwner;
    List<Post> findAllByBlogger;
}
