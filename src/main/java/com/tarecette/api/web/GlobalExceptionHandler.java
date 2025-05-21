package com.tarecette.api.web;


import com.tarecette.api.exceptions.EmailDejaUtiliseException;
import com.tarecette.api.exceptions.IdentifiantsInvalideException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailDejaUtiliseException.class)
    public ResponseEntity<String> handleEmailDejaUtilise( EmailDejaUtiliseException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
    @ExceptionHandler(IdentifiantsInvalideException.class)
    public ResponseEntity<String> handleIdentifiantsInvalideException(IdentifiantsInvalideException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
