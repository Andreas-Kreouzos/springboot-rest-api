package com.andrekreou.springboot.coursetwo.service;

import com.andrekreou.springboot.coursetwo.dto.UserDto;
import com.andrekreou.springboot.coursetwo.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);
}
