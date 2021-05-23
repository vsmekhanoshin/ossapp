package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.entities.*;
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

        if (requestUserDto.getStyleLevelList().size() > 3){
            System.out.println("Ошибка: в Листе Юзер-Стиль больше 3 значений");
        }

        requestUserDto.getStyleLevelList().stream()
                .forEach(u -> saveUserStyle(u, user));

        return user;
    }

    private void saveUserStyle(List<Long> styleLevelList, User user) {
        if (styleLevelList.size() > 2) {
            System.out.println("Ошибка: в Листе Стиль-Левел больше 2 значений");
        }
        long styleId = styleLevelList.get(0); // вид ед-ва
        long levelId = styleLevelList.get(1); // ур-нь маст-ва
        Long styleLevelId = styleLevelRepository.findByStyleIdAndLevelId(styleId, levelId);

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