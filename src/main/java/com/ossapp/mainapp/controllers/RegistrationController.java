package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.VerificationToken;
import com.ossapp.mainapp.entities.dto.UserDto;
import com.ossapp.mainapp.service.impl.UserService;
import com.ossapp.mainapp.service.impl.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
public class RegistrationController {
    VerificationTokenService verificationTokenService;
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @GetMapping("/get")
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/user")
    public User showRegistrationForm() {
        UserDto userDto = new UserDto();
        userDto.setEmail("mailforossapp@gmail.com");
        userDto.setPassword("100");
        userDto.setName("Pisch");
        userDto.setWeight(1);
        userDto.setSex(1);
        User registered = userService.registerNewUserAccount(userDto);
        System.out.println(registered.getId());
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered));
        return registered;
    }

    @GetMapping("/registrationConfirm")
    public User confirmRegistration
            (@RequestParam("token") String token) {
        VerificationToken verificationToken = verificationTokenService.getTokenFromDB(token);

        if (verificationToken == null) throw new RuntimeException("Invalid token!");
        User user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();

        if (verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0)
            throw new RuntimeException("Token is expired!");
        user.setEnabled(true);
        System.out.println(user.isEnabled());
        System.out.println(user.getId());
        return userService.saveRegisteredUser(user);
    }
}
