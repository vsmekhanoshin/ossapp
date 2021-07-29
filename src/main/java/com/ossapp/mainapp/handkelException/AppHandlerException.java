package com.ossapp.mainapp.handkelException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ossapp.mainapp.dto.ExceptionMassageDto;

@ControllerAdvice
public class AppHandlerException {

    @ExceptionHandler
    @ResponseBody
    private ResponseEntity<ExceptionMassageDto> handleCountStyleOutOfBalanceException(CountStyleOutOfBalanceException e) {
        return new ResponseEntity<>(new ExceptionMassageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    private ResponseEntity<ExceptionMassageDto> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new ExceptionMassageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

}