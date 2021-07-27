package com.ossapp.mainapp.dto.mappers;

import com.ossapp.mainapp.dto.*;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.entities.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import static com.ossapp.mainapp.dto.mappers.CityMapper.*;

public class UserMapper {
    public static ResponseUserDto getDtoFromUser(User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
//        responseUserDto.setId(user.getId());
        responseUserDto.setEmail(user.getEmail());
//        responseUserDto.setPhone(user.getPhone());
        responseUserDto.setName(user.getName());
        responseUserDto.setNickTelegram(user.getNickTelegram());
        responseUserDto.setAge(calculateAge(user.getBirthDate()));
        responseUserDto.setWeight(WeightUser.getAgeUser(user.getWeight()));
        responseUserDto.setSex(SexUser.getSexUser(user.getSex()));
        responseUserDto.setCity(getDtoFromCity(user.getCityId()));
        responseUserDto.setAbout(user.getAbout());
//        responseUserDto.setImages(user.getImages());
        responseUserDto.setStylesLevels(getResponseStyleLevelDtoList(user.getStylesLevels()));
        return responseUserDto;
    }
    private static ResponseStyleLevelDto fromStyleLevelDtoToResponseStyleLevelDto(StyleLevel styleLevel) {
        ResponseStyleLevelDto responseStyleLevelDto = new ResponseStyleLevelDto();
        responseStyleLevelDto.setStyleName(styleLevel.getStyleName());
        responseStyleLevelDto.setLevelName(styleLevel.getLevelName());
        return responseStyleLevelDto;
    }

    private static List<ResponseStyleLevelDto> getResponseStyleLevelDtoList(List<StyleLevel> styleLevelList) {
        return styleLevelList
                .stream()
                .map(s -> fromStyleLevelDtoToResponseStyleLevelDto(s))
                .collect(Collectors.toList());
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

    private static Integer calculateAge(LocalDate bthDay) {
        if (bthDay == null) {
            return null;
        }
        LocalDate currentYear = LocalDate.now();
        return Period.between(bthDay, currentYear).getYears();
    }
}
