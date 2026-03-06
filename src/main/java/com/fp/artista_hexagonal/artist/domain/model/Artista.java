package com.fp.artista_hexagonal.artist.domain.model;

public class Artista {
   private Long id;
   private String nombre;


   public Artista(Long id, String nombre) {
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
