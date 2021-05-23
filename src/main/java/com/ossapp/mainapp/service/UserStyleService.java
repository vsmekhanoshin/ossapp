package com.ossapp.mainapp.service;

import com.ossapp.mainapp.entities.PkUserStyleLevelId;
import com.ossapp.mainapp.entities.UserStyle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserStyleService {
    UserStyle findById(PkUserStyleLevelId id);

    List<UserStyle> findAll();

//    UserStyle save(RequestUserStyleDto requestUserStyleDto);
//
//    Long deleteById(Long id);
//
//    UserStyle update(RequestUserStyleDto requestUserStyleDto, long id);

}
