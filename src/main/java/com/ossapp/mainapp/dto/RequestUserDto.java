package com.ossapp.mainapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.User;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
public class RequestUserDto {

    @Email
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private String name;

    private String nickTelegram;

    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date bthDay;

    @Min (1)
    private int weight;

    @Min (1)
    @Max(2)
    private int sex;

    @Min (1)
    private long cityId;

    @NotNull
    @Size(min = 1, max = 3)
    private List<RequestStyleLevelDto> requestStyleLevelDtoList; // 1,2

    private String about;

    public User fromRequestUserToUser(RequestUserDto requestStyleDto, City city) {
        User user = new User();
        user.setEmail(requestStyleDto.getEmail());
        user.setPassword(requestStyleDto.getPassword());
        user.setPhone(requestStyleDto.getPhone());
        user.setName(requestStyleDto.getName());
        user.setNickTelegram(requestStyleDto.getNickTelegram());
        user.setWeight(requestStyleDto.getWeight());
        user.setSex(requestStyleDto.getSex());
        user.setCityId(city);
        user.setAbout(requestStyleDto.getAbout());
        return user;
    }
}
