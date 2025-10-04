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

    @ExceptionHandler(LinkJaExistenteException.class)
    public ResponseEntity<String> handleConflict(LinkJaExistenteException ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }

    @ExceptionHandler(MinimoDeCaracteresNaoAlcancadoException.class)
    public ResponseEntity<String> handleBadRequest(MinimoDeCaracteresNaoAlcancadoException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(CaracterInvalidoException.class)
    public ResponseEntity<String> handleBadRequest(CaracterInvalidoException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }
}
