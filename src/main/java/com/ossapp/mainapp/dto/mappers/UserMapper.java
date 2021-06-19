package com.ossapp.mainapp.dto.mappers;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.dto.ResponseUserDto;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.entities.User;

import java.util.List;
import java.util.stream.Collectors;

import static com.ossapp.mainapp.dto.mappers.CityMapper.*;

public class UserMapper {
    public static ResponseUserDto getDtoFromUser(User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
//        responseUserDto.setId(user.getId());
//        responseUserDto.setEmail(user.getEmail());
//        responseUserDto.setPhone(user.getPhone());
        responseUserDto.setName(user.getName());
//        responseUserDto.setNickTelegram(user.getNickTelegram());
//        responseUserDto.setBirthDate(user.getBirthDate());
        responseUserDto.setWeight(user.getWeight());
        responseUserDto.setSex(user.getSex());
        responseUserDto.setCity(getDtoFromCity(user.getCityId()));
        responseUserDto.setAbout(user.getAbout());
//        responseUserDto.setImages(user.getImages());
        responseUserDto.setStylesLevels(getRequestStyleLevelDtoList(user.getStylesLevels()));
        return responseUserDto;
    }

    private static RequestStyleLevelDto fromStyleLevelDtoToRequestStyleLevel(StyleLevel styleLevel) {
        RequestStyleLevelDto requestStyleLevelDto = new RequestStyleLevelDto();
        requestStyleLevelDto.setStyle(styleLevel.getStyle());
        requestStyleLevelDto.setLevel(styleLevel.getLevel());
        return requestStyleLevelDto;
    }

    private static List<RequestStyleLevelDto> getRequestStyleLevelDtoList(List<StyleLevel> styleLevelList) {
        return styleLevelList
                .stream()
                .map(s -> fromStyleLevelDtoToRequestStyleLevel(s))
                .collect(Collectors.toList());
    }
}
