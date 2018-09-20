//package com.bloggertime.nowblog.services;
//
//
//import com.bloggertime.nowblog.models.User;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Random;
//
//@Service
//public class UserServices {
//
//    private User userDao;
//
//
//    public UserServices(User userDao) {
//        this.userDao = userDao;
//    }
//
//
//    public User findRandomUser() {
//        List<User> users = userDao.findAll();
//        Random random = new Random();
//        return users.get(random.nextInt(users.size()));
//    }
//
//    public User save (User user) {
//        return userDao.save(user);
//    }
//}
