package com.fp.artista_hexagonal.artist.domain.port.in;

import com.fp.artista_hexagonal.artist.domain.model.Artista;

import java.util.List;

public interface ArtistaUseCase{
    Artista crearArtista(String nombre);
    List<Artista> obtenerTodos();
}
