package com.andrekreou.springboot.coursetwo.service;

import com.andrekreou.springboot.coursetwo.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
}
