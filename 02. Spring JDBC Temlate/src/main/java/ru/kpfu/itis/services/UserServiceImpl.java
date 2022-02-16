package ru.kpfu.itis.services;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.exceptions.RedBalanceException;
import ru.kpfu.itis.repositories.MusicRepository;
import ru.kpfu.itis.repositories.UsersRepository;

public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;
    private MusicRepository musicRepository;

    public UserServiceImpl(UsersRepository usersRepository, MusicRepository musicRepository) {
        this.usersRepository = usersRepository;
        this.musicRepository = musicRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RedBalanceException.class)
    public void buyPlaylist(Long id) {
        //достаем пользователя,
        // меняем его баланс
        // перечислить кому-то
        // открыть доступ

    }
}
