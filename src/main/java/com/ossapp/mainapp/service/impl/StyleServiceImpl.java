package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.dto.RequestStyleDto;
import com.ossapp.mainapp.entities.Style;
import com.ossapp.mainapp.repositories.StyleRepository;
import com.ossapp.mainapp.service.StyleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StyleServiceImpl implements StyleService {
    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public Style findById(Long id) {
        return styleRepository.findById(id).get();
    }

    @Override
    public Style save(RequestStyleDto requestStyleDto) {
        return styleRepository.save(requestStyleDto.fromRequestStyleToStyle(requestStyleDto));
    }

    @Override
    public Long deleteById(Long id) {
        styleRepository.deleteById(id);
        return id;
    }

    @Override
    public Style update(RequestStyleDto requestStyleDto, long id) {
        Optional<Style> styleOptional = styleRepository.findById(id);
        styleOptional.get().setName(requestStyleDto.getName());
        return styleRepository.save(styleOptional.get());
    }
}
