package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.entities.Level;
import com.ossapp.mainapp.entities.Style;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.repositories.LevelRepository;
import com.ossapp.mainapp.repositories.StyleLevelRepository;
import com.ossapp.mainapp.repositories.StyleRepository;
import com.ossapp.mainapp.service.StyleLevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StyleLevelServiceImpl implements StyleLevelService {
    private final StyleLevelRepository styleLevelRepository;
    private final StyleRepository styleRepository;
    private final LevelRepository levelRepository;

    public StyleLevelServiceImpl(StyleLevelRepository styleLevelRepository, StyleRepository styleRepository, LevelRepository levelRepository) {
        this.styleLevelRepository = styleLevelRepository;
        this.styleRepository = styleRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public StyleLevel findById(Long id) {
        return styleLevelRepository.findById(id).get();
    }

    @Override
    public StyleLevel save(RequestStyleLevelDto requestStyleLevelDto) {
        Optional<Style> styleOpt = styleRepository.findById(requestStyleLevelDto.getStyleId());
        Optional<Level> levelOpt = levelRepository.findById(requestStyleLevelDto.getLevelId());
        return styleLevelRepository.save(requestStyleLevelDto
                .fromRequestStyleLevelToStyleLevel(requestStyleLevelDto, styleOpt.get(), levelOpt.get()));
    }

    @Override
    public Long deleteById(Long id) {
        styleLevelRepository.deleteById(id);
        return id;
    }

    @Override
    public StyleLevel update(RequestStyleLevelDto requestStyleLevelDto, long id) {
        Optional<StyleLevel> styleLevelOptional = styleLevelRepository.findById(id);
        Optional<Style> styleOpt = styleRepository.findById(requestStyleLevelDto.getStyleId());
        Optional<Level> levelOpt = levelRepository.findById(requestStyleLevelDto.getLevelId());

        styleLevelOptional.get().setStyleId(styleOpt.get());
        styleLevelOptional.get().setLevelId(levelOpt.get());
        return styleLevelRepository.save(styleLevelOptional.get());
    }

    @Override
    public List<StyleLevel> findAll() {
        return styleLevelRepository.findAll();
    }
}
