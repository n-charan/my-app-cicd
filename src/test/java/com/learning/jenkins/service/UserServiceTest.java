package com.learning.jenkins.service;

import com.learning.jenkins.dto.UserDto;
import com.learning.jenkins.entity.User;
import com.learning.jenkins.mapper.UserMapper;
import com.learning.jenkins.repo.UserRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Test to get all users when it exits")
    public void getAllUserTest1() {
        User user1 = new User(1, "Abcd", "Efgh", "abcd.efgh@test.com", "Pune", "India");
        User user2 = new User(2, "Tuv", "Xyz", "tuv.xyz@test.com", "Bangalore", "India");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        UserDto userDto1 = new UserDto(user1.getId(), user1.getFirstName(), user1.getLastName(), user1.getEmail(), user1.getCity());
        UserDto userDto2 = new UserDto(user2.getId(), user2.getFirstName(), user2.getLastName(), user2.getEmail(), user2.getCity());
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(userDto1);
        userDtoList.add(userDto2);

        when(userRepo.getAll()).thenReturn(userList);
        when(userMapper.toDtoList(userList)).thenReturn(userDtoList);

        List<UserDto> userDtos = userService.getAllUsers();
        assertAll(
                () -> assertNotNull(userDtos),
                () -> assertEquals(2, userDtos.size())
        );
    }

    @Test
    @DisplayName("Test to get all users when it does not exits")
    public void getAllUserTest2() {
        when(userRepo.getAll()).thenReturn(null);
        when(userMapper.toDtoList(null)).thenReturn(null);

        List<UserDto> userDtos = userService.getAllUsers();
        assertAll(
                () -> assertNull(userDtos)
        );
    }

    @Test
    @DisplayName("Test to get user by id when it exits")
    public void getUserByIdTest1() {
        User user = new User(1, "Abcd", "Efgh", "abcd.efgh@test.com", "Pune", "India");
        UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity());

        when(userRepo.getById(user.getId())).thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(userDto);

        UserDto fetchedUserDto = userService.getUserById(user.getId());
        assertAll(
                () -> assertNotNull(fetchedUserDto),
                () -> assertEquals(user.getId(), fetchedUserDto.getId(), "Id does not match"),
                () -> assertEquals(user.getEmail(), fetchedUserDto.getEmail(), "Email does not match")
        );
    }

    @Test
    @DisplayName("Test to get user by id when it does not exits")
    public void getUserByIdTest2() {
        Integer id = 4;
        when(userRepo.getById(id)).thenReturn(Optional.empty());
        when(userMapper.toDto(null)).thenReturn(null);

        UserDto userDto = userService.getUserById(id);
        assertAll(
                () -> assertNull(userDto)
        );
    }
}
