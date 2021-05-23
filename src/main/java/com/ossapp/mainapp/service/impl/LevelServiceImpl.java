package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestLevelDto;
import com.ossapp.mainapp.entities.Level;
import com.ossapp.mainapp.repositories.LevelRepository;
import com.ossapp.mainapp.service.LevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelStyleRepository;

    public LevelServiceImpl(LevelRepository levelStyleRepository) {
        this.levelStyleRepository = levelStyleRepository;
    }

    @Override
    public Level findById(Long id) {
        return levelStyleRepository.findById(id).get();
    }

    @Override
    public Level save(RequestLevelDto requestLevelDto) {
        return levelStyleRepository.save(requestLevelDto.fromRequestLevelToLevel(requestLevelDto));
    }

    @Override
    public Long deleteById(Long id) {
        levelStyleRepository.deleteById(id);
        return id;
    }

    @Override
    public Level update(RequestLevelDto requestLevelDto, long id) {
        Optional<Level> styleOptional = levelStyleRepository.findById(id);
        styleOptional.get().setValue(requestLevelDto.getValue());
        return levelStyleRepository.save(styleOptional.get());
    }

    @Override
    public List<Level> findAll() {
        return levelStyleRepository.findAll();
    }
}
