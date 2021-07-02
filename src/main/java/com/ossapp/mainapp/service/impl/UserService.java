package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.dto.UserDto;
import com.ossapp.mainapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }

    
}
