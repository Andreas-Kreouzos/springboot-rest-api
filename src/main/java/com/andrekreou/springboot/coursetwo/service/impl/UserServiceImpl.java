package com.andrekreou.springboot.coursetwo.service.impl;

import com.andrekreou.springboot.coursetwo.dto.UserDto;
import com.andrekreou.springboot.coursetwo.entity.User;
import com.andrekreou.springboot.coursetwo.mapper.UserMapper;
import com.andrekreou.springboot.coursetwo.repository.UserRepository;
import com.andrekreou.springboot.coursetwo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    /**
     * Converts UserDto into User JPA Entity and then back
     * again from User JPA Entity to UserDto
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
