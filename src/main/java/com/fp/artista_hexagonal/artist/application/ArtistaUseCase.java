package com.fp.artista_hexagonal.artist.application;

import com.fp.artista_hexagonal.artist.application.exception.ArtistaDuplicadoException;
import com.fp.artista_hexagonal.artist.application.exception.ArtistaInvalidoException;
import com.fp.artista_hexagonal.artist.domain.model.Artista;
import com.fp.artista_hexagonal.artist.domain.port.ArtistaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ArtistaUseCase {
    private final ArtistaRepositoryPort repository;

    public ArtistaUseCase(ArtistaRepositoryPort repository) {
        this.repository = repository;
    }

    public Artista crearArtista(String nombre) {
        validarNombre(nombre);
        Optional<Artista> existente = repository.buscarPorNombre(nombre);

        if (existente.isPresent()) {
            throw new ArtistaDuplicadoException(
                    "Ya existe un artista con nombre: " + nombre
            );
        }

        Artista artista = new Artista(null, nombre);

        return repository.guardar(artista);
    }

    public List<Artista> obtenerTodos() {
        return repository.obtenerTodos();
    }

    private void validarNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new ArtistaInvalidoException("El nombre del artista no puede estar vacío");
        }

        if (nombre.length() < 3) {
            throw new ArtistaInvalidoException("El nombre del artista debe tener al menos 3 caracteres");
        }
    }
}
