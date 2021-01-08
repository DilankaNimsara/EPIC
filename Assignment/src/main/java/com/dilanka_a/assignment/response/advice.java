package com.dilanka_a.assignment.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class advice {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity handle(RuntimeException e) {

        return new ResponseEntity(new stdResponses(400, "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
