package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.StyleLevel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class RequestStyleLevelDto {

    @Min(1)
    @Max(11)
    private Long style;

    @Min(1)
    @Max(4)
    private Long level;

    public StyleLevel fromRequestStyleLevelDtoToStyleLevel(RequestStyleLevelDto requestStyleLevelDto) {
        StyleLevel styleLevel = new StyleLevel();
        styleLevel.setStyle(requestStyleLevelDto.getStyle());
        styleLevel.setLevel(requestStyleLevelDto.getLevel());
        return styleLevel;
    }
}
