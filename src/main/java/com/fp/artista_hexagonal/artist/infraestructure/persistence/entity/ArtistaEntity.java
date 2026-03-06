package com.fp.artista_hexagonal.artist.infraestructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="artistas")
public class ArtistaEntity {
   @Id
   @GeneratedValue
   private Long id;
   private String nombre;


   public ArtistaEntity() {}
   public ArtistaEntity(Long id, String nombre) {
       this.id = id;
       this.nombre = nombre;
   }
   public Long getId() {
       return id;
   }
   public String getNombre() {
       return nombre;
   }
}
