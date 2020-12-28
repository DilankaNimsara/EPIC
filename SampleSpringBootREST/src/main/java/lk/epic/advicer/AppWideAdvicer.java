package lk.epic.advicer;

import lk.epic.util.staranded.StdRespons;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdvicer {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity handler(RuntimeException e) {
        StdRespons error = new StdRespons(400, "Error", e.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
