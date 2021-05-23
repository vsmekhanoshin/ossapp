package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.Level;
import com.ossapp.mainapp.entities.Style;
import com.ossapp.mainapp.entities.StyleLevel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class RequestStyleLevelDto {
    @Min(1)
    @Max(9)
    private Long styleId;

    @Min(1)
    @Max(4)
    private Long levelId;

    public StyleLevel fromRequestStyleLevelToStyleLevel(
            RequestStyleLevelDto requestLevelStyleDto,
            Style style, Level level) {
        StyleLevel styleLevel = new StyleLevel();
        styleLevel.setStyleId(style);
        styleLevel.setLevelId(level);
        return styleLevel;
    }
}
