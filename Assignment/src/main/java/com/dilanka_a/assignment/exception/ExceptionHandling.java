package com.dilanka_a.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity Handle(RuntimeException e) {
        return new ResponseEntity("not found", HttpStatus.NOT_FOUND);
    }

}
