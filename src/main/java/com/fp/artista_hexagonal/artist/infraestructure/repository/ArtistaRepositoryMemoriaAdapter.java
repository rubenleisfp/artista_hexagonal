package com.fp.artista_hexagonal.artist.infraestructure.repository;


import com.fp.artista_hexagonal.artist.domain.model.Artista;
import com.fp.artista_hexagonal.artist.domain.port.out.ArtistaRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ArtistaRepositoryMemoriaAdapter implements ArtistaRepositoryPort {
    private Map<Long, Artista> baseDatos = new HashMap<>();
    private Long contador = 1L;


    @Override
    public Artista guardar(Artista artista) {
        Artista nuevo = new Artista(contador++, artista.getNombre());
        baseDatos.put(nuevo.getId(), nuevo);
        return nuevo;
    }
    @Override
    public Artista buscarPorId(Long id) {
        return baseDatos.get(id);
    }

    @Override
    public List<Artista> obtenerTodos() {
        return new ArrayList<>(baseDatos.values());
    }

    @Override
    public Optional<Artista> buscarPorNombre(String nombre) {
        for (Artista artista : baseDatos.values()) {
            if (artista.getNombre().equals(nombre)) {
                return Optional.of(artista);
            }
        }
        return Optional.empty();
    }

}

