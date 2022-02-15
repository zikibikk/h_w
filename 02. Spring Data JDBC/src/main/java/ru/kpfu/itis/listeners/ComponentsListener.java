package ru.kpfu.itis.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
//Обрабатывает события создания/удаления контекста сервлета
public class ComponentsListener implements ServletContextListener {

    //Получает уведомление, что процесс инициализации веб-приложения запускается.

    //Все ServletContextListeners уведомляются относительно инициализации контекста
    // перед любыми фильтрами, или сервлеты в веб-приложении инициализируются.
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        servletContextEvent.getServletContext().setAttribute("applicationContext", context);
    }

    //Получает уведомление, что ServletContext собирается быть выключенным.

    //Все сервлеты и фильтры будут уничтожены прежде, чем любые ServletContextListeners
    // уведомляются относительно разрушения контекста.
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
