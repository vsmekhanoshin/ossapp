package com.ossapp.mainapp.dto;

import com.ossapp.mainapp.entities.Skill;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class RequestSkillDto {
    @Min(1)
    @Max(5)
    private int value;

    public Skill fromRequestSkillToSkill(RequestSkillDto requestSkillDto) {
        Skill skill = new Skill();
        skill.setValue(requestSkillDto.getValue());
        return skill;
    }
}
