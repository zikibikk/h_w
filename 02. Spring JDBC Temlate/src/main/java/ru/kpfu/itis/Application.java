package ru.kpfu.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UsersRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = context.getBean(UsersRepository.class);

       /*User danil = User.builder()
               .firstName("Даниль")
               .lastName("Галеев")
               .build();

       User evelina = User.builder()
               .firstName("Эвелина")
               .lastName("Меметова")
               .build();

       User marat = User.builder()
               .firstName("Марат")
               .lastName("Гиниятов")
               .build();

       usersRepository.saveAll(List.of(danil, evelina, marat));*/

        User danil = User.builder()
                .firstName("Даниль")
                .lastName("Галеев")
                .build();

        usersRepository.save(danil);

    }
}
