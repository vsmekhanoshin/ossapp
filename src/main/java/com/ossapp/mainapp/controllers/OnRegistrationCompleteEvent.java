package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@Setter
@Getter
public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private User user;

    public OnRegistrationCompleteEvent(
            User user) {
        super(user);
        this.user = user;
    }
}
