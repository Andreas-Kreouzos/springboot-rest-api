package com.andrekreou.springboot.coursetwo.mapper;

import com.andrekreou.springboot.coursetwo.dto.UserDto;
import com.andrekreou.springboot.coursetwo.entity.User;

public class UserMapper {

    /**
     * Converts User JPA Entity into UserDto
     */
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    /**
     * Converts UserDto into User JPA Entity
     */
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
