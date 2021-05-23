package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.PkUserStyleLevelId;
import com.ossapp.mainapp.entities.User;
import com.ossapp.mainapp.entities.UserStyle;
import com.ossapp.mainapp.repositories.*;
import com.ossapp.mainapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

        List<UserStyle> userStyleList = requestUserDto.getStyleLevel().stream()
                .forEach(u -> );

        return null;
    }

    private void saveUserStyle(Map<Long, List<Long>> styleLevelMap, User user){

        for (int i = 0; i < styleLevelMap.size(); i++) {
            long styleId = styleLevelMap.get(i).get(1);
            long LevelId = styleLevelMap.get(i).get(2);

            long styleLevelId = styleLevelRepository.findById()

        }

        PkUserStyleLevelId pkUserStyleLevelId = new PkUserStyleLevelId();
        pkUserStyleLevelId.setUserId(user.getId());
        //TODO найти по id style and id level
        pkUserStyleLevelId.setStyleLevelId();

        UserStyle userStyle = new UserStyle();
        userStyle.setPkUserStyleLevelId(pkUserStyleLevelId);

        styleLevelRepositoryy.save(userStyle);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}