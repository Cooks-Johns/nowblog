package com.bloggertime.nowblog.services;

import com.bloggertime.nowblog.models.User;
import com.bloggertime.nowblog.repositories.PostRepository;
import com.bloggertime.nowblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

        public Post save(PostRepository postDao) {
            User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = usersDao.findUsersById(sessionUser.getId());
            post.setOwner(user);


            geoDao.save(post);
            return post;
        }



        public Geocache findById(long id) {
            return geoDao.findById(id);
        }

        public List<Post> findAllByOwnerId(long id){return postDao.findAllByOwner_Id(id);}
        public List<Post> findAllByFinderId(long id){return postDao.findAllByFinder_Id(id);}



    }
