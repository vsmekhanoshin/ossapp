package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestSkillDto;
import com.ossapp.mainapp.entities.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {
    Skill findById(Long id);

    Skill save(RequestSkillDto requestSkillDto);

    Long deleteById(Long id);

    Skill update(RequestSkillDto requestSkillDto, long id);

    List<Skill> findAll();
}
