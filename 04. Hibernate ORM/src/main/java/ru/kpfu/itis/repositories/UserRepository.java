package ru.kpfu.itis.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
