package com.denis.link.shortener.exceptions;

public class LinkJaExistenteException extends RuntimeException {
    public LinkJaExistenteException(String custumShortLink) {
        super("O Link '/"+custumShortLink+"' já está sendo utilizado.");
    }
}
