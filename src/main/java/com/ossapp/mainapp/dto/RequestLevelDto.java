package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.Level;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class RequestLevelDto {
    @Min(1)
    @Max(5)
    private int value;

    public Level fromRequestLevelToLevel(RequestLevelDto requestLevelStyleDto) {
        Level level = new Level();
        level.setValue(requestLevelStyleDto.getValue());
        return level;
    }
}
