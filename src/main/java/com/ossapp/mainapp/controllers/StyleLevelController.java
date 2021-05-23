package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestStyleLevelDto;
import com.ossapp.mainapp.entities.StyleLevel;
import com.ossapp.mainapp.service.StyleLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/style-level")
public class StyleLevelController {
    private final StyleLevelService styleLevelService;

    public StyleLevelController(StyleLevelService styleLevelService) {
        this.styleLevelService = styleLevelService;
    }

    @PostMapping
    public ResponseEntity<RequestStyleLevelDto> post(@RequestBody @Valid RequestStyleLevelDto requestStyleLevelDto) {
        styleLevelService.save(requestStyleLevelDto);
        return new ResponseEntity<>(requestStyleLevelDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<StyleLevel> getAll() {
        return styleLevelService.findAll();
    }

    @GetMapping("/{id}")
    public StyleLevel getById(@PathVariable("id") Long id) {
        return styleLevelService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") long id) {
        return styleLevelService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequestStyleLevelDto update(@RequestBody @Valid RequestStyleLevelDto requestStyleLevelDto, @PathVariable("id") long id) {
        styleLevelService.update(requestStyleLevelDto, id);
        return requestStyleLevelDto;
    }
}
