package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.service.impl.UserService;
import com.ossapp.mainapp.service.impl.VerificationTokenService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@NoArgsConstructor
public class RegistrationListener implements
        ApplicationListener<OnRegistrationCompleteEvent> {
    private VerificationTokenService VerificationTokenService;
    private JavaMailSender javaMailSender;

    @Value("${email.verify.url: http://localhost:8080/registrationConfirm?token=}")
    private String confirmationUrl;

    @Value("${spring.mail.username: mailforossapp@gmail.com}")
    private String emailUsername;

    @Value("${spring.mail.password: 1234oss*}")
    private String emailPassword;

    @Autowired
    public void setEmailVerificationTokenService(VerificationTokenService VerificationTokenService) {
        this.VerificationTokenService = VerificationTokenService;
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        VerificationTokenService.createToken(user, token);

        String recipientAddress = user.getEmail();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailUsername);
        message.setTo(recipientAddress);
        message.setSubject("Confirm your email");
        message.setText("Address confirmation \r\n" + confirmationUrl + token);
        javaMailSender.send(message);
    }
}
