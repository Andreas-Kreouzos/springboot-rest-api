package com.andrekreou.springboot.coursetwo.service.impl;

import com.andrekreou.springboot.coursetwo.entity.User;
import com.andrekreou.springboot.coursetwo.repository.UserRepository;
import com.andrekreou.springboot.coursetwo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
