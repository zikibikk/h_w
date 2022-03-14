package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.User;

import java.util.List;

public interface UsersService {
    void addUser(UserDto userDto);
    List<User> getUsers();
    User getUserById(Long id);
}
