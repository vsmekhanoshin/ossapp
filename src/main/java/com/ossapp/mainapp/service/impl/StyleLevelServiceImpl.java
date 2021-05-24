package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.repositories.StyleLevelRepository;
import com.ossapp.mainapp.service.StyleLevelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StyleLevelServiceImpl implements StyleLevelService {
    private final StyleLevelRepository styleLevelRepository;

    public StyleLevelServiceImpl(StyleLevelRepository styleLevelRepository) {
        this.styleLevelRepository = styleLevelRepository;
    }

    @Override
    public StyleLevel findById(Long id) {
        return styleLevelRepository.findById(id).get();
    }

    @Override
    public StyleLevel save(RequestStyleLevelDto requestStyleLevelDto) {
        return styleLevelRepository.save(requestStyleLevelDto
                .fromRequestStyleLevelDtoToStyleLevel(requestStyleLevelDto));
    }

    @Override
    public Long deleteById(Long id) {
        styleLevelRepository.deleteById(id);
        return id;
    }

    @Override
    public StyleLevel update(RequestStyleLevelDto requestStyleLevelDto, long id) {
        Optional<StyleLevel> styleLevelOptional = styleLevelRepository.findById(id);

        styleLevelOptional.get().setStyle(requestStyleLevelDto.getStyle());
        styleLevelOptional.get().setLevel(requestStyleLevelDto.getLevel());
        return styleLevelRepository.save(styleLevelOptional.get());
    }

    @Override
    public List<StyleLevel> findAll() {
        return styleLevelRepository.findAll();
    }
}
