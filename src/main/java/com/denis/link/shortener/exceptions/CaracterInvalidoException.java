package com.denis.link.shortener.exceptions;

public class CaracterInvalidoException extends RuntimeException {
    public CaracterInvalidoException() {
        super("O Link personalizado não deve conter o caracter especial '/'.");
    }
}
