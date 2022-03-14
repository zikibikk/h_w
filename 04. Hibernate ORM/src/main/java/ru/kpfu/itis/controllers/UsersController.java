package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.UsersService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    @Qualifier("userService")
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = usersService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("userAddPage");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(UserDto userDto) {
//        UserDto userDto = UserDto.builder()
//                        .firstName(firstName)
//                                .lastName(lastName)
//                                        .build();
        usersService.addUser(userDto);
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public ModelAndView getUserById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = usersService.getUserById(id);
        modelAndView.addObject("users", List.of(user));
        modelAndView.setViewName("userAddPage");
        return modelAndView;
    }


}
