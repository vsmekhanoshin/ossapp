package com.ossapp.mainapp.service;

import com.ossapp.mainapp.dto.RequestLevelDto;
import com.ossapp.mainapp.entities.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelService {
    Level findById(Long id);

    Level save(RequestLevelDto requestLevelDto);

    Long deleteById(Long id);

    Level update(RequestLevelDto requestLevelDto, long id);

    List<Level> findAll();
}
