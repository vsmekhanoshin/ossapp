package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.dto.UserDto;
import com.ossapp.mainapp.service.impl.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class RegistrationController {
    UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User showRegistrationForm() {
        UserDto userDto = new UserDto();
        userDto.setEmail("ololoqwerty@dfgh.gom");
        userDto.setPassword("100");
        userDto.setUsername("Pisch");
        return userService.registerNewUserAccount(userDto);
    }
}
