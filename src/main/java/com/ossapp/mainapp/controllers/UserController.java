package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestUserDto;
import com.ossapp.mainapp.dto.ResponseUserDto;
import com.ossapp.mainapp.service.UserService;
import com.ossapp.mainapp.utils.UserFilter;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<ResponseUserDto> getAllUsers(@RequestParam(required = false) Map<String, String> requestParams) {
//            @RequestParam(value = "ageBefore", required = false) Integer ageBefore,
//            @RequestParam(value = "ageAfter", required = false) Integer ageAfter,
//            @RequestParam(value = "style", required = false) Integer style,
//            @RequestParam(value = "level", required = false) Integer level,
//            @RequestParam(value = "sex", required = false) Integer sex,
//            @RequestParam(value = "weight", required = false) Integer weight,
//            @RequestParam(value = "cityId", required = false) Integer cityId,

//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "9") Integer size,
        int pageNumber = Integer.parseInt(requestParams.getOrDefault("page", "0"));
        int sizeNumber = Integer.parseInt(requestParams.getOrDefault("size", "10"));

        Integer ageBefore = null;
        Integer ageAfter = null;
        Long cityId = null;
        Long style = null;
        Integer level = null;
        Integer sex = null;
        Integer weight = null;

        if (requestParams.containsKey("ageBefore") || requestParams.containsKey("ageAfter")) {
            ageBefore = Integer.parseInt(requestParams.getOrDefault("ageBefore", "150"));
            ageAfter = Integer.parseInt(requestParams.getOrDefault("ageAfter", "1"));
        }

        if (requestParams.containsKey("cityId")) {
            //TODO поиск после добаления Security через UserDetails client = (UserDetails) auth.getPrincipal();
            // long id = ((User) client).getUserId();
            Long userCity = userService.findCityIdByUserId(1L);
            cityId = Long.parseLong(requestParams.getOrDefault("cityId", userCity.toString()));
        }

        if (requestParams.containsKey("style")) {
            style = Long.parseLong(requestParams.getOrDefault("style", "1"));
        }

        if (requestParams.containsKey("level")) {
            level = Integer.parseInt(requestParams.getOrDefault("level", "1"));
        }

        if (requestParams.containsKey("sex")) {
            sex = Integer.parseInt(requestParams.getOrDefault("sex", "1"));
        }

        if (requestParams.containsKey("weight")) {
            weight = Integer.parseInt(requestParams.getOrDefault("weight", "1"));
        }

        UserFilter userFilter = new UserFilter(ageBefore, ageAfter, cityId, style, level, sex, weight);

        return userService.findAll(userFilter.getSpec(), pageNumber, sizeNumber);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RequestUserDto> post(@RequestBody @Valid RequestUserDto requestUserDto) {
        userService.save(requestUserDto);
        return new ResponseEntity<>(requestUserDto, HttpStatus.OK);
    }

}
