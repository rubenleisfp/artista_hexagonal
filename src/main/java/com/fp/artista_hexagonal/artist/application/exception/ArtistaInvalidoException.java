package com.fp.artista_hexagonal.artist.application.exception;

public class ArtistaInvalidoException extends RuntimeException {

    public ArtistaInvalidoException(String mensaje) {
        super(mensaje);
    }
}