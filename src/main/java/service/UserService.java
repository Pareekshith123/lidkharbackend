package service;
import java.util.List;

import com.Dtos.UserDto;

import Entities.User;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Integer id, UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Integer id);

    String deleteUser(Integer id);
}
