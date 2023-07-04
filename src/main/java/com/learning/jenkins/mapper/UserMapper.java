package com.learning.jenkins.mapper;

import com.learning.jenkins.dto.UserDto;
import com.learning.jenkins.dto.UserRequestDto;
import com.learning.jenkins.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> userList);

    User toEntity(UserRequestDto userRequestDto);
}
