package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.Style;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequestStyleDto {
    @NotBlank
    private int value;

    public Style fromRequestStyleToStyle(RequestStyleDto requestStyleDto) {
        Style style = new Style();
        style.setValue(requestStyleDto.getValue());
        return style;
    }
}
