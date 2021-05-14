package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.Style;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestStyleDto {
    @NotBlank
    private String name;

    public Style fromRequestStyleToStyle(RequestStyleDto requestStyleDto) {
        Style style = new Style();
        style.setName(requestStyleDto.getName());
        return style;
    }
}
