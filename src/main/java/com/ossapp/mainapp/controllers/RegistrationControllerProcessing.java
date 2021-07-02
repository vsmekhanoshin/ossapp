package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.VerificationToken;
import com.ossapp.mainapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Calendar;
import java.util.Locale;

@RestController
public class RegistrationControllerProcessing {
    @Autowired
    private IUserService service;

    @GetMapping("/regitrationConfirm")
    public String confirmRegistration
            (@RequestParam("token") String token) {

        Locale locale = Locale.ENGLISH;

        VerificationToken verificationToken = service.getVerificationToken(token);
        if (verificationToken == null) {
//            String message = messages.getMessage("auth.message.invalidToken", null, locale);
//            model.addAttribute("message", message);
            return "Eat pussy";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
//            String messageValue = messages.getMessage("auth.message.expired", null, locale);
//            model.addAttribute("message", messageValue);
            return "Eat pussy";
        }

        user.setEnabled(true);
        service.saveRegisteredUser(user);
        return "All it's ok";
    }
}
