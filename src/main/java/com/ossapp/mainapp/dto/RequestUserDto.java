package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.City;
import com.ossapp.mainapp.entities.User;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

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

    private String phone;

    @Min (1)
    private int weight;

    @Min (1)
    @Max(2)
    private int sex;

    @Min (1)
    private long cityId;

    @NotNull
    @Size(max = 3)
    //TODO какой List
    private List<Map<Long, List<Long>>> styleLevel;

    private String about;

    public User fromRequestUserToUser(RequestUserDto requestStyleDto, City city) {
        User user = new User();
        user.setEmail(requestStyleDto.getEmail());
        user.setPassword(requestStyleDto.getPassword());
        user.setPhone(requestStyleDto.getPhone());
        user.setName(requestStyleDto.getName());
        user.setWeight(requestStyleDto.getWeight());
        user.setSex(requestStyleDto.getSex());
        user.setCityId(city);
        user.setAbout(requestStyleDto.getAbout());
        return user;
    }
}
