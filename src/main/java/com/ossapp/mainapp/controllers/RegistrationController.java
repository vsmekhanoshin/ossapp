package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class RegistrationController {
    @GetMapping("/user/registration")
    public String showRegistrationForm() {
        UserDto userDto = new UserDto();
        return "registration";
    }
}
