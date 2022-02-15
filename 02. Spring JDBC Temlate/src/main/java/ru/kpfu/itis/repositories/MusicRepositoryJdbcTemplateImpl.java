package ru.kpfu.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.kpfu.itis.models.Music;

import java.util.Optional;

public class MusicRepositoryJdbcTemplateImpl implements MusicRepository {

    private JdbcTemplate jdbcTemplate;

    public MusicRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Music> S save(S entity) {

        return null;
    }

    @Override
    public <S extends Music> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Music> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Music> findAll() {
        return null;
    }

    @Override
    public Iterable<Music> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Music entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Music> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
