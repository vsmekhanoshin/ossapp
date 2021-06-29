package com.ossapp.mainapp.dto;

import lombok.Data;

@Data
public class ResponseCityDto {
    private Long id;

    private String name;

    private String region;

    private String country;
}
