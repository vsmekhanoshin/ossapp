package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.entities.PkUserStyleLevelId;
import com.ossapp.mainapp.entities.UserStyle;
import com.ossapp.mainapp.repositories.UserStyleRepository;
import com.ossapp.mainapp.service.UserStyleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserStyleServiceImpl implements UserStyleService {
    private final UserStyleRepository userStyleRepository;

    public UserStyleServiceImpl(UserStyleRepository userStyleRepository) {
        this.userStyleRepository = userStyleRepository;
    }

    @Override
    public UserStyle findById(PkUserStyleLevelId id) {
        return userStyleRepository.findById(id).get();
    }

    @Override
    public List<UserStyle> findAll() {
        return userStyleRepository.findAll();
    }

//    @Override
//    public UserStyle save(RequestUserStyleDto requestUserStyleDto) {
//        return styleRepository.save(requestStyleDto.fromRequestStyleToStyle(requestStyleDto));
//    }
//
//    @Override
//    public Long deleteById(Long id) {
//        styleRepository.deleteById(id);
//        return id;
//    }
//
//    @Override
//    public UserStyle update(RequestUserStyleDto requestUserStyleDto, long id) {
//        Optional<Style> styleOptional = styleRepository.findById(id);
//        styleOptional.get().setValue(requestStyleDto.getValue());
//        return styleRepository.save(styleOptional.get());
//    }

}
