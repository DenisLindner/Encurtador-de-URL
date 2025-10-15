package com.denis.link.shortener.exceptions;

public class LinkInvalidoException extends RuntimeException {
    public LinkInvalidoException(String url) {
        super("O Link '"+url+"' é inválido.");
    }
}
