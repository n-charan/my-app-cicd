package com.learning.jenkins.service;

import com.learning.jenkins.dto.UserDto;
import com.learning.jenkins.dto.UserRequestDto;
import com.learning.jenkins.entity.User;
import com.learning.jenkins.mapper.UserMapper;
import com.learning.jenkins.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepo.getAll();
        return userMapper.toDtoList(userList);
    }

    public UserDto getUserById(Integer userId) {
        Optional<User> userOptional = userRepo.getById(userId);
        if (userOptional.isPresent()) {
            return userMapper.toDto(userOptional.get());
        }
        return userMapper.toDto(null);
    }

    public UserDto saveUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        user = userRepo.save(user);
        return userMapper.toDto(user);
    }

    public UserDto updateUser(Integer userId, UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        user = userRepo.update(userId, user);
        return userMapper.toDto(user);
    }
}
