package ru.kpfu.itis.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<User> userRowMapper = ((resultSet, i) -> {
        return User.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .build();
    });

    //language=SQL
    private static final String SQL_INSERT = "insert into users(first_name, last_name) values (:firstName, :lastName)";

    //language=SQL
    private static final String SQL_SELECT = "select * from users where id=?";


    public UsersRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public <S extends User> S save(S user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(SQL_INSERT, namedParameters, keyHolder, new String[]{"id"});
        /*jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());

            return statement;
        }, keyHolder);*/

        user.setId(keyHolder.getKey().longValue());

        return user;
    }

    /**
     * Использование batch режима выполнения запросов обычно гораздо эффективнее.
     * В этом режиме запросы не выполняются сразу, каждый по отдельности,
     * а накапливаются и выполняются одним большим запросом с множеством данных.
     * Например, если вы делаете несколько update запросов, то каждый запрос будет
     * выполнен как отдельный самостоятельный запрос. В batch режиме ваши update
     * запросы будут отправлены одним заданием, что производительнее.
     *
     * @param users
     * @param <S>
     * @return
     */
    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> users) {
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(userList.toArray());
        namedParameterJdbcTemplate.batchUpdate(SQL_INSERT, batch);
        /*jdbcTemplate.batchUpdate(SQL_INSERT, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, userList.get(i).getFirstName());
                ps.setString(2, userList.get(i).getLastName());
            }

            @Override
            public int getBatchSize() {
                return userList.size();
            }
        });*/
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT, userRowMapper, id);
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
