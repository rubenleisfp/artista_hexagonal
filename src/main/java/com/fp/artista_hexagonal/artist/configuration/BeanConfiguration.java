package com.fp.artista_hexagonal.artist.configuration;

import com.fp.artista_hexagonal.artist.application.ArtistaUseCase;
import com.fp.artista_hexagonal.artist.domain.port.ArtistaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
   @Bean
   public ArtistaUseCase crearArtistaUseCase(ArtistaRepositoryPort repository)
   {
       return new ArtistaUseCase(repository);
   }
}
