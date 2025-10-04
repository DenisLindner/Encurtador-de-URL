package com.denis.link.shortener.exceptions;

public class LinkNaoEncontradoException extends RuntimeException {
    public LinkNaoEncontradoException(String shortLink) {
        super("Link não encontrado: 'localhost:9999/" + shortLink+"'");
    }
}
