package com.ossapp.mainapp.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleRNFException(ResourceNotFoundException e) {
        log.error(e.getMessage());
        BookServiceError err = new BookServiceError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleJwtExpired(ExpiredJwtException e) {
        log.error("!!!");
        return new ResponseEntity<>(new BookServiceError(HttpStatus.UNAUTHORIZED.value(), "JWT Token expired"), HttpStatus.UNAUTHORIZED);
    }
}
