package com.backend.service.serviceImpl;

import org.modelmapper.ModelMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Dtos.UserDto;

import com.backend.Entities.User;
import com.backend.repository.UserRepo;
import com.backend.service.UserService;

import com.backend.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;



    @Override
    public UserDto createUser(UserDto userDto) {




        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {



        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMobileNumber(userDto.getMobileNumber()); // Fixed typo here
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);
        UserDto savedUser = this.userToDto(updatedUser);
        return savedUser;
    }

    @Override
    public List<UserDto> getAllUsers() {




        List<User> userList = this.userRepo.findAll();
        List<UserDto> userListDto = userList.stream().map(this::userToDto).collect(Collectors.toList());
        return userListDto;
    }

    @Override
    public UserDto getUserById(Integer id) {



        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        return this.userToDto(user);
    }

    @Override
    public String deleteUser(Integer id) {


        User user = this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        this.userRepo.delete(user);
        return "The user is deleted successfully";
    }

    public UserDto userToDto(User user) {



        return this.modelMapper.map(user, UserDto.class);
    }

    public User dtoToUser(UserDto userDto) {


        return this.modelMapper.map(userDto, User.class);
    }
}
