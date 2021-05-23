package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestLevelDto;
import com.ossapp.mainapp.entities.Level;
import com.ossapp.mainapp.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/levels")
public class LevelController {
    private final LevelService levelStyleService;

    public LevelController(LevelService levelStyleService) {
        this.levelStyleService = levelStyleService;
    }

    @PostMapping
    public ResponseEntity<RequestLevelDto> post(@RequestBody @Valid RequestLevelDto requestLevelStyleDto) {
        levelStyleService.save(requestLevelStyleDto);
        return new ResponseEntity<>(requestLevelStyleDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<Level> getAll() {
        return levelStyleService.findAll();
    }

    @GetMapping("/{id}")
    public Level getById(@PathVariable("id") Long id) {
        return levelStyleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") long id) {
        return levelStyleService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequestLevelDto update(@RequestBody @Valid RequestLevelDto requestLevelStyleDto, @PathVariable("id") long id) {
        levelStyleService.update(requestLevelStyleDto, id);
        return requestLevelStyleDto;
    }
}
