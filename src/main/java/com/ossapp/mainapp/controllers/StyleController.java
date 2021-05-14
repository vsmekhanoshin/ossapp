package com.ossapp.mainapp.controllers;

import com.ossapp.mainapp.dto.RequestStyleDto;
import com.ossapp.mainapp.entities.Style;
import com.ossapp.mainapp.service.StyleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/style")
public class StyleController {
    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @PostMapping
    public ResponseEntity<RequestStyleDto> post(@RequestBody @Valid RequestStyleDto requestProviderDto) {
        styleService.save(requestProviderDto);
        return new ResponseEntity<>(requestProviderDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Style get(@PathVariable("id") Long id) {
        return styleService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Long delete(@PathVariable("id") long id) {
        return styleService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public RequestStyleDto update(@RequestBody  @Valid RequestStyleDto requestStyleDto, @PathVariable("id") long id) {
        styleService.update(requestStyleDto, id);
        return requestStyleDto;
    }
}