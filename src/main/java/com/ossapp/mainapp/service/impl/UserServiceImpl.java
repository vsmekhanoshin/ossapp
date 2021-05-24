package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.repositories.UserRepository;
import com.ossapp.mainapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(int page) {
        if (page < 1L) {
            page = 0;
        }
        return userRepository.findAll(PageRequest.of(page, 1)).getContent();
    }

    public User findById(Long id) {
        return userRepository.getOne(id);
    }
}
