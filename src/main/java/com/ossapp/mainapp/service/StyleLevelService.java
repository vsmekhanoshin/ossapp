package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.entities.StyleLevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StyleLevelService {
    StyleLevel findById(Long id);

    StyleLevel save(RequestStyleLevelDto requestStyleLevelDto);

    Long deleteById(Long id);

    StyleLevel update(RequestStyleLevelDto requestStyleLevelDto, long id);

    List<StyleLevel> findAll();
}
