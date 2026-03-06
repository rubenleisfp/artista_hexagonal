package com.fp.artista_hexagonal.artist.application.exception;

public class ArtistaDuplicadoException extends RuntimeException {

    public ArtistaDuplicadoException(String mensaje) {
        super(mensaje);
    }

}