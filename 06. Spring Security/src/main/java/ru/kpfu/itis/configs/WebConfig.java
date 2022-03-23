package ru.kpfu.itis.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"ru.kpfu.itis.controllers"})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/style/**").addResourceLocations("/resources/style/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
//        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/resources/scripts/");
//        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resources/img/");
    }

}
