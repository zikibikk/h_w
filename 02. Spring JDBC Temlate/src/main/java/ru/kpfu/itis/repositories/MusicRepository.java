package ru.kpfu.itis.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.models.Music;

public interface MusicRepository extends CrudRepository<Music, Long> {
}
