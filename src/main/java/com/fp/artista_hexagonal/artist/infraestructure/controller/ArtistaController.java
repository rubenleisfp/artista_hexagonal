package com.fp.artista_hexagonal.artist.infraestructure.controller;

import com.fp.artista_hexagonal.artist.application.ArtistaUseCase;
import com.fp.artista_hexagonal.artist.application.exception.ArtistaInvalidoException;
import com.fp.artista_hexagonal.artist.domain.model.Artista;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
   private final ArtistaUseCase artistaUseCase;
   public ArtistaController(ArtistaUseCase artistaUseCase) {
       this.artistaUseCase = artistaUseCase;
   }

   @PostMapping
   public Artista crear(@RequestBody String nombre){
       return artistaUseCase.crearArtista(nombre);
   }

    @GetMapping
    public List<Artista> obtenerTodos() {
        return artistaUseCase.obtenerTodos();
    }

    @ExceptionHandler(ArtistaInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String manejarError(ArtistaInvalidoException ex) {
        return ex.getMessage();
    }
}
