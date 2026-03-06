package com.fp.artista_hexagonal.artist.infraestructure.persistence.repository;

import com.fp.artista_hexagonal.artist.infraestructure.persistence.entity.ArtistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataArtistaRepository
       extends JpaRepository<ArtistaEntity, Long> {
    
    Optional<ArtistaEntity> findByNombre(String nombre);
}
