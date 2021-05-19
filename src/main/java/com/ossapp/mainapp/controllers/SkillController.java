package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestSkillDto;
import com.ossapp.mainapp.entities.Skill;
import com.ossapp.mainapp.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/levels")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<RequestSkillDto> post(@RequestBody @Valid RequestSkillDto requestSkillDto) {
        skillService.save(requestSkillDto);
        return new ResponseEntity<>(requestSkillDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<Skill> getAll() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Skill getById(@PathVariable("id") Long id) {
        return skillService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") long id) {
        return skillService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequestSkillDto update(@RequestBody @Valid RequestSkillDto requestSkillDto, @PathVariable("id") long id) {
        skillService.update(requestSkillDto, id);
        return requestSkillDto;
    }
}
