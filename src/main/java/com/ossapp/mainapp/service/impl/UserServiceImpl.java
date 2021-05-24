package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.PkUserStyleLevelId;
import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.UserStyle;
import com.ossapp.mainapp.repositories.CityRepository;
import com.ossapp.mainapp.repositories.StyleLevelRepository;
import com.ossapp.mainapp.repositories.UserRepository;
import com.ossapp.mainapp.repositories.UserStyleRepository;
import com.ossapp.mainapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserStyleRepository userStyleRepository;
    private final StyleLevelRepository styleLevelRepository;
    private final CityRepository cityRepository;

    public UserServiceImpl(UserRepository userRepository,
                           UserStyleRepository userStyleRepository,
                           StyleLevelRepository styleLevelRepository,
                           CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.userStyleRepository = userStyleRepository;
        this.styleLevelRepository = styleLevelRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public User save(RequestUserDto requestUserDto) {
        Optional<City> cityOpt = cityRepository.findById(requestUserDto.getCityId());
        User user = requestUserDto.fromRequestUserToUser(requestUserDto, cityOpt.get());

        userRepository.save(user);

        if (requestUserDto.getRequestStyleLevelDtoList().size() > 3) {
            System.out.println("Ошибка: в Листе Юзер-Стиль больше 3 значений");
        }

        requestUserDto.getRequestStyleLevelDtoList().stream()
                .forEach(u -> saveUserStyle(u, user));

        return user;
    }

    private void saveUserStyle(RequestStyleLevelDto requestStyleLevelDto, User user) {
        Long styleLevelId = styleLevelRepository.findByStyleIdAndLevelId
                (requestStyleLevelDto.getStyle(), requestStyleLevelDto.getLevel());

        PkUserStyleLevelId pkUserStyleLevelId = new PkUserStyleLevelId();
        pkUserStyleLevelId.setUser_id(user.getId());
        pkUserStyleLevelId.setStyle_level_id(styleLevelId);

        UserStyle userStyle = new UserStyle();
        userStyle.setPkUserStyleLevelId(pkUserStyleLevelId);
        userStyleRepository.save(userStyle);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}