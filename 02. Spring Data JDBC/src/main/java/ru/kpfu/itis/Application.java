package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;
import ru.kpfu.itis.repositories.UserRepositoryJdbcTemplateImpl;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
//        String url = "jdbc:postgresql://localhost:5435/test_project";
//        String username = "postgres";
//        String password = "postgres";
//        DataSource dataSource = new DriverManagerDataSource(url, username, password);
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        UserRepository userRepository = new UserRepositoryJdbcTemplateImpl(jdbcTemplate);

//        User user = new User();
//        user.setFirstName("Даниль");
//        user.setLastName("Галеев");
//        user.setPasswordHash("asdfghjkl");
//        user.setLogin("danil");
//        user = userRepository.save(user);
//        System.out.println(user.getId());

//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        UserRepository userRepository = context.getBean(UserRepository.class);
//
//        System.out.println(userRepository.findById(7L).get());

//        Properties properties = new Properties();
//        try {
//            properties.load(new FileReader("src\\main\\resources\\application.properties"));
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
//        String url = properties.getProperty("db.url");
//        System.out.println(url);
    }
}
