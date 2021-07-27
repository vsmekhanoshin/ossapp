package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.entities.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResponseUserDto {

    private String name;

    private Integer age;

    private String weight;

    private String email;

    private String sex;

    private ResponseCityDto city;

    private String about;

    private String nickTelegram;

//    private List<UserImages> images;

    private List<ResponseStyleLevelDto> stylesLevels;


    public ResponseUserDto fromUserToResponseUserDto(User user, List<StyleLevel> styleLevelList, City city) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setName(user.getName());
        responseUserDto.setWeight(WeightUser.getAgeUser(user.getWeight()));
        responseUserDto.setSex(SexUser.getSexUser(user.getSex()));
        responseUserDto.setCity(fromRequestCityToCity(city));
        responseUserDto.setStylesLevels(getResponseStyleLevelDtoList(styleLevelList));
        responseUserDto.setAge(calculateAge(user.getBirthDate()));
        return responseUserDto;
    }

    private ResponseStyleLevelDto fromStyleLevelDtoToResponseStyleLevelDto(StyleLevel styleLevel) {
        ResponseStyleLevelDto responseStyleLevelDto = new ResponseStyleLevelDto();
        responseStyleLevelDto.setStyleName(styleLevel.getStyleName());
        responseStyleLevelDto.setLevelName(styleLevel.getLevelName());
        return responseStyleLevelDto;
    }

    private List<ResponseStyleLevelDto> getResponseStyleLevelDtoList(List<StyleLevel> styleLevelList) {
        return styleLevelList
                .stream()
                .map(s -> fromStyleLevelDtoToResponseStyleLevelDto(s))
                .collect(Collectors.toList());
    }

    private RequestStyleLevelDto fromStyleLevelDtoToRequestStyleLevel(StyleLevel styleLevel) {
        RequestStyleLevelDto requestStyleLevelDto = new RequestStyleLevelDto();
        requestStyleLevelDto.setStyle(styleLevel.getStyle());
        requestStyleLevelDto.setLevel(styleLevel.getLevel());
        return requestStyleLevelDto;
    }

    private List<RequestStyleLevelDto> getRequestStyleLevelDtoList(List<StyleLevel> styleLevelList) {
        return styleLevelList
                .stream()
                .map(s -> fromStyleLevelDtoToRequestStyleLevel(s))
                .collect(Collectors.toList());
    }

    private ResponseCityDto fromRequestCityToCity(City city) {
        ResponseCityDto requestCityDto = new ResponseCityDto();
        requestCityDto.setName(city.getName());
        requestCityDto.setRegion(city.getRegion());
        requestCityDto.setCountry(city.getCountry());
        return requestCityDto;
    }

    private Integer calculateAge(LocalDate bthDay) {
        if (bthDay == null) {
            return null;
        }
        LocalDate currentYear = LocalDate.now();
        return Period.between(bthDay, currentYear).getYears();
    }
}
