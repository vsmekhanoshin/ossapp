package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.StyleLevel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResponseStyleLevelDto {

    @NotBlank
    @NotNull
    private String styleName;

    @NotBlank
    @NotNull
    private String levelName;

    public ResponseStyleLevelDto fromRequestStyleLevelDtoToStyleLevel(StyleLevel styleLevel) {
        ResponseStyleLevelDto responseStyleLevelDto = new ResponseStyleLevelDto();
        responseStyleLevelDto.setStyleName(styleLevel.getStyleName());
        responseStyleLevelDto.setLevelName(styleLevel.getLevelName());
        return responseStyleLevelDto;
    }
}
