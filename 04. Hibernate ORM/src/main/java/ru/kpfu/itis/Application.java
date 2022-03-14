package ru.kpfu.itis;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kpfu.itis.models.Product;
import ru.kpfu.itis.models.User;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Product tea = Product.builder()
                .title("Черный чай")
                .description("Вкусный черный чай с ароматом лаванды")
                .cost(599.99)
                .build();
        Product grechka = Product.builder()
                .title("Гречка")
                .description("Стоит дороже чем вкусный черный чай")
                .cost(601.99)
                .build();

        User user = User.builder()
                .firstName("Башир")
                .lastName("Галеев")
                .bucket(List.of(tea, grechka))
                .build();

        session.save(tea);
        session.save(grechka);

        session.save(user);


        session.close();

        sessionFactory.close();


    }
}
