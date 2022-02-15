package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryJdbcTemplateImpl;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
//        Properties properties = new Properties();
//
//        try {
//            properties.load(new FileReader("src\\main\\resources\\application.properties"));
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
//
//        String url = properties.getProperty("db.url");
//        String username = properties.getProperty("db.user");
//        String password = properties.getProperty("db.password");
//
//
//        DataSource dataSource = new DriverManagerDataSource(url, username, password);
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(jdbcTemplate);

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = context.getBean(UsersRepository.class);

        User user = new User();
        user.setLastName("LastName");
        user.setFirstName("FirstName");
        usersRepository.save(user);

        System.out.println(user.toString());

        System.out.println(usersRepository.findById(15L));

    }
}
