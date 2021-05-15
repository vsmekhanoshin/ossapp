package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestLevelStyleDto;
import com.ossapp.mainapp.entities.LevelStyle;
import com.ossapp.mainapp.service.LevelStyleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/levels")
public class LevelStyleController {
    private final LevelStyleService levelStyleService;

    public LevelStyleController(LevelStyleService levelStyleService) {
        this.levelStyleService = levelStyleService;
    }

    @PostMapping
    public ResponseEntity<RequestLevelStyleDto> post(@RequestBody @Valid RequestLevelStyleDto requestLevelStyleDto) {
        levelStyleService.save(requestLevelStyleDto);
        return new ResponseEntity<>(requestLevelStyleDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<LevelStyle> getAll() {
        return levelStyleService.findAll();
    }

    @GetMapping("/{id}")
    public LevelStyle getById(@PathVariable("id") Long id) {
        return levelStyleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") long id) {
        return levelStyleService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequestLevelStyleDto update(@RequestBody @Valid RequestLevelStyleDto requestLevelStyleDto, @PathVariable("id") long id) {
        levelStyleService.update(requestLevelStyleDto, id);
        return requestLevelStyleDto;
    }
}
