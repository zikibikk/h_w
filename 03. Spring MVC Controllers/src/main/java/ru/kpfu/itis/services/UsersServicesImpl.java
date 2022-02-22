package ru.kpfu.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.repositories.UserRepository;

public class UsersServicesImpl implements UsersService {

    private UserRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServicesImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    //todo some logic
}
