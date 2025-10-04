package com.denis.link.shortener.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkNaoEncontradoException.class)
    public ResponseEntity<String> handleNotFound(LinkNaoEncontradoException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
