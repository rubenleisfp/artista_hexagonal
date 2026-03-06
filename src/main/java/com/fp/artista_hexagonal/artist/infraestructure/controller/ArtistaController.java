package com.fp.artista_hexagonal.artist.infraestructure.controller;

import com.fp.artista_hexagonal.artist.application.ArtistaUseCase;
import com.fp.artista_hexagonal.artist.application.exception.ArtistaDuplicadoException;
import com.fp.artista_hexagonal.artist.application.exception.ArtistaInvalidoException;
import com.fp.artista_hexagonal.artist.domain.model.Artista;
import com.fp.artista_hexagonal.artist.infraestructure.controller.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ErrorResponse> manejarError(ArtistaInvalidoException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ArtistaDuplicadoException.class)
    public ResponseEntity<ErrorResponse> manejarErrorDuplicado(ArtistaDuplicadoException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}