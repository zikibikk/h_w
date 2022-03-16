package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;

import java.util.List;

@Service("userService")
public class UsersServicesImpl implements UsersService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void addUser(UserDto userDto) {
        User user = User.builder()
                        .lastName(userDto.getLastName())
                                .firstName(userDto.getFirstName())
                                        .build();
        usersRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public int getUserCountByLastName(String lastName) {
        return usersRepository.countUserByLastName(lastName);
    }
}
