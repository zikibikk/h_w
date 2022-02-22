package ru.kpfu.itis.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.models.User;

import java.sql.PreparedStatement;
import java.util.Optional;

public class UserRepositoryJdbcTemplateImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = ((resultSet, rowNum) -> {
        return User.builder()
                .id(resultSet.getLong("id"))
                .lastName(resultSet.getString("last_name"))
                .firstName(resultSet.getString("first_name"))
                .build();
    });

    //language=sql
    private final String SQL_INSERT = "INSERT INTO users(first_name, last_name, login, password_hash) VALUES (?, ?, ?, ?)";

    private final String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE id=?;";
    public UserRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends User> S save(S user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPasswordHash());

            return statement;
        }, keyHolder);

        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_USER_BY_ID, userRowMapper, id);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public boolean existsById(Long aLong) {

        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
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
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
