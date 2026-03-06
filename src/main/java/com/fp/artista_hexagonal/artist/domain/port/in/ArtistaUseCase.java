package com.fp.artista_hexagonal.artist.domain.port.in;

import com.fp.artista_hexagonal.artist.domain.model.Artista;

import java.util.List;

public interface ArtistaUseCase{
    public Artista crearArtista(String nombre);
    public List<Artista> obtenerTodos();
}
