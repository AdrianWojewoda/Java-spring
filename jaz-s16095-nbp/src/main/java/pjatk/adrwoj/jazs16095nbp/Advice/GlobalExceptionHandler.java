package pjatk.adrwoj.jazs16095nbp.Advice;

import pjatk.adrwoj.jazs16095nbp.Exception.NBPBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NBPBadRequestException.class)
    public ResponseEntity<String> handleRuntimeException(NBPBadRequestException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Exception: " + e.getLocalizedMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInternalServerError(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("EXception: " + e.getLocalizedMessage());
    }
}