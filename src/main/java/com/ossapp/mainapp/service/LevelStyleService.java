package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestLevelStyleDto;
import com.ossapp.mainapp.entities.LevelStyle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelStyleService {
    LevelStyle findById(Long id);

    LevelStyle save(RequestLevelStyleDto requestLevelStyleDto);

    Long deleteById(Long id);

    LevelStyle update(RequestLevelStyleDto requestLevelStyleDto, long id);

    List<LevelStyle> findAll();
}
