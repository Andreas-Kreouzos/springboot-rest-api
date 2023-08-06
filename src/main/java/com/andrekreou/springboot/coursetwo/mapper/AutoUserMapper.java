package com.andrekreou.springboot.coursetwo.mapper;

import com.andrekreou.springboot.coursetwo.dto.UserDto;
import com.andrekreou.springboot.coursetwo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
