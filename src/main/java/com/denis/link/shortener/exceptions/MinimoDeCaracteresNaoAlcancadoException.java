package com.denis.link.shortener.exceptions;

public class MinimoDeCaracteresNaoAlcancadoException extends RuntimeException {
    public MinimoDeCaracteresNaoAlcancadoException() {
        super("O Link personalizadp deve ter no mínimo 3 caracteres.");
    }
}
