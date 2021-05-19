package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestSkillDto;
import com.ossapp.mainapp.entities.Skill;
import com.ossapp.mainapp.repositories.SkillRepository;
import com.ossapp.mainapp.service.SkillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
    private final SkillRepository SkillRepository;

    public SkillServiceImpl(SkillRepository SkillRepository) {
        this.SkillRepository = SkillRepository;
    }

    @Override
    public Skill findById(Long id) {
        return SkillRepository.findById(id).get();
    }

    @Override
    public Skill save(RequestSkillDto requestSkillDto) {
        return SkillRepository.save(requestSkillDto.fromRequestSkillToSkill(requestSkillDto));
    }

    @Override
    public Long deleteById(Long id) {
        SkillRepository.deleteById(id);
        return id;
    }

    @Override
    public Skill update(RequestSkillDto requestSkillDto, long id) {
        Optional<Skill> styleOptional = SkillRepository.findById(id);
        styleOptional.get().setValue(requestSkillDto.getValue());
        return SkillRepository.save(styleOptional.get());
    }

    @Override
    public List<Skill> findAll() {
        return SkillRepository.findAll();
    }
}
