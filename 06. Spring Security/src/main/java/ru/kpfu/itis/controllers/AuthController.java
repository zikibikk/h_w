package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.services.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/signUp")
    public String signUpPage() {
        return "signUp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public ModelAndView signUpUser(ModelAndView modelAndView, RegistrationDto registrationDto) {
        userService.signUp(registrationDto);
        modelAndView.setViewName("redirect:/signIn");
        return modelAndView;
    }
}
