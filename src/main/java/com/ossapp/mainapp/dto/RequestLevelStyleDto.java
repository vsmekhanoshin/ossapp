package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.LevelStyle;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class RequestLevelStyleDto {
    @Min(1)
    @Max(5)
    private int value;

    public LevelStyle fromRequestLevelStyleToLevelStyle(RequestLevelStyleDto requestLevelStyleDto) {
        LevelStyle levelStyle = new LevelStyle();
        levelStyle.setValue(requestLevelStyleDto.getValue());
        return levelStyle;
    }
}
