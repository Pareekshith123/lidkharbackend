package com.backend.service;
import java.util.List;

import com.backend.Dtos.UserDto;

import com.backend.Entities.User;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Integer id, UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Integer id);

    String deleteUser(Integer id);
}
