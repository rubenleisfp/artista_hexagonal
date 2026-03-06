package com.fp.artista_hexagonal.artist.domain.port;


import com.fp.artista_hexagonal.artist.domain.model.Artista;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepositoryPort {
   Artista guardar(Artista artista);
   Artista buscarPorId(Long id);
   List<Artista> obtenerTodos();
   Optional<Artista> buscarPorNombre(String nombre);
}
