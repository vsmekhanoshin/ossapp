package com.ossapp.mainapp.service;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.VerificationToken;
import com.ossapp.mainapp.entities.dto.UserDto;

public interface IUserService {

    User registerNewUserAccount(UserDto userDto);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);
}
