package com.bloggertime.nowblog.services;

import com.bloggertime.nowblog.models.Post;
import com.bloggertime.nowblog.models.User;
import com.bloggertime.nowblog.repositories.PostRepository;
import com.bloggertime.nowblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
        private final PostRepository postDao;
        private final UserRepository usersDao;


        public PostService  (PostRepository postDao, UserRepository usersDao) {
            this.postDao = postDao;
            this.usersDao = usersDao;
        }




        public List<Post> findAll() {
            return postDao.findAll();
        }

        public Post save(Post post) {
            User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = usersDao.findUserById(sessionUser.getId());
            post.setOwner(user);


            postDao.save(post);
            return post;
        }



        public Post findById(long id) {
            return postDao.findById(id);
        }

        public List<Post> findAllByOwnerId(long id) {
            return postDao.findAllByOwner_ID(id);
        }




    }
