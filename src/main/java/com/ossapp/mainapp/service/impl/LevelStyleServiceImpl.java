package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestLevelStyleDto;
import com.ossapp.mainapp.entities.LevelStyle;
import com.ossapp.mainapp.repositories.LevelStyleRepository;
import com.ossapp.mainapp.service.LevelStyleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LevelStyleServiceImpl implements LevelStyleService {
    private final LevelStyleRepository levelStyleRepository;

    public LevelStyleServiceImpl(LevelStyleRepository levelStyleRepository) {
        this.levelStyleRepository = levelStyleRepository;
    }

    @Override
    public LevelStyle findById(Long id) {
        return levelStyleRepository.findById(id).get();
    }

    @Override
    public LevelStyle save(RequestLevelStyleDto requestLevelStyleDto) {
        return levelStyleRepository.save(requestLevelStyleDto.fromRequestLevelStyleToLevelStyle(requestLevelStyleDto));
    }

    @Override
    public Long deleteById(Long id) {
        levelStyleRepository.deleteById(id);
        return id;
    }

    @Override
    public LevelStyle update(RequestLevelStyleDto requestLevelStyleDto, long id) {
        Optional<LevelStyle> styleOptional = levelStyleRepository.findById(id);
        styleOptional.get().setValue(requestLevelStyleDto.getValue());
        return levelStyleRepository.save(styleOptional.get());
    }

    @Override
    public List<LevelStyle> findAll() {
        return levelStyleRepository.findAll();
    }
}
