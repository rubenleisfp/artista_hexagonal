package com.fp.artista_hexagonal.artist.infraestructure.persistence.repository;

import com.fp.artista_hexagonal.artist.domain.model.Artista;
import com.fp.artista_hexagonal.artist.domain.port.ArtistaRepositoryPort;
import com.fp.artista_hexagonal.artist.infraestructure.persistence.entity.ArtistaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistaRepositoryJpaAdapter implements ArtistaRepositoryPort {
    private final SpringDataArtistaRepository repository;


    public ArtistaRepositoryJpaAdapter(SpringDataArtistaRepository repository) {
        this.repository = repository;
    }


    @Override
    public Artista guardar(Artista artista) {
        ArtistaEntity entity =
                new ArtistaEntity(null, artista.getNombre());


        ArtistaEntity guardado = repository.save(entity);
        return new Artista(
                guardado.getId(),
                guardado.getNombre()
        );
    }


    @Override
    public Artista buscarPorId(Long id) {
        Optional<ArtistaEntity> entity = repository.findById(id);
        if(entity.isPresent()) {


            Artista e = new Artista(
                    entity.get().getId(),
                    entity.get().getNombre()
            );


            return e;
        }
        return null;
    }

    @Override
    public List<Artista> obtenerTodos() {
        List<ArtistaEntity> entities = repository.findAll();
        return entities.stream()
                .map(entity -> new Artista(entity.getId(), entity.getNombre()))
                .toList();
    }

    @Override
    public Optional<Artista> buscarPorNombre(String nombre) {
        Optional<ArtistaEntity> entity = repository.findByNombre(nombre);
        return entity.map(e -> new Artista(e.getId(), e.getNombre()));
    }
}

