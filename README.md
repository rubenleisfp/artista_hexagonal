# Artista Hexagonal

Proyecto de gestión de artistas implementado con arquitectura hexagonal (Ports and Adapters) utilizando Spring Boot.

# Rama
En esta versión se trabaja con una repositorio que guarda la información en memoria
En esta ocasión la manera de llevar a cabo la arquitectura ha sido más estricta
Se crea un puerto de entrada (interfaz) ArtistaUseCase
Para no depender de anotaciones de Spring propias de la capa de @Service como @Transactional
Esa interfaz será implementada por la clase ArtistaService
El controlador se desacopla del servicio ya que utiliza ArtistaUseCase que no tiene
nada que ver con Spring

## Arquitectura

El proyecto sigue el patrón de arquitectura hexagonal para separar claramente la lógica de negocio de la infraestructura:

### Dominio (Domain)
- **Model**: `Artista` - Entidad principal del dominio
- **Port (out)**: `ArtistaRepositoryPort` - Interfaz que define los contratos del repositorio
- **Port (int)**: `ArtistaUseCase` - Intefaz que Contiene la lógica de negocio para la gestión de artistas

### Aplicación (Application)
- **Service**: `ArtistaUseCase` -Implementa la lógica de negocio para la gestion de artistas con Spring
- **Exceptions**: `ArtistaInvalidoException`, `ArtistaDuplicadoException` - Manejo de errores de negocio

### Infraestructura (Infrastructure)
- **Controller**: `ArtistaController` - Endpoints REST para la API
- **Repository**: `ArtistaRepositoryMemoriaAdapter` - Implementación en memoria del repositorio
- **Configuration**: `BeanConfiguration` - Configuración de beans de Spring

## Características

- ✅ CRUD de artistas
- ✅ Validación de nombres (mínimo 3 caracteres)
- ✅ Prevención de duplicados
- ✅ Manejo de excepciones con HTTP status codes apropiados
- ✅ Documentación automática con Swagger/OpenAPI
- ✅ Arquitectura hexagonal limpia y escalable

## Tecnologías

- **Java 17+**
- **Spring Boot 3.x**
- **Maven**
- **Swagger/OpenAPI 3**
- **JUnit 5** (para testing)

## Requisitos

- Java 17 o superior
- Maven 3.6 o superior

## Instalación y Ejecución

1. Clonar el repositorio:
```bash
git clone <repository-url>
cd artista_hexagonal
```

2. Compilar el proyecto:
```bash
mvn clean compile
```

3. Ejecutar las pruebas:
```bash
mvn test
```

4. Iniciar la aplicación:
```bash
mvn spring-boot:run
```

La aplicación se iniciará en `http://localhost:8080`

## Endpoints de la API

### Crear Artista
- **URL**: `POST /artistas`
- **Body**: `"nombre del artista"`
- **Response**: Objeto Artista creado
- **Status**: 201 Created

### Obtener Todos los Artistas
- **URL**: `GET /artistas`
- **Response**: Lista de artistas
- **Status**: 200 OK

### Ejemplos de Uso

#### Crear un artista
```bash
curl -X POST http://localhost:8080/artistas \
  -H "Content-Type: application/json" \
  -d '"Pablo Picasso"'
```

#### Obtener todos los artistas
```bash
curl -X GET http://localhost:8080/artistas
```

## Documentación API

### Swagger UI
Accede a la documentación interactiva de la API:
- **URL**: `http://localhost:8080/swagger-ui.html`
- **URL**: `http://localhost:8080/swagger-ui/index.html`

### OpenAPI Specification
Especificación OpenAPI en formato JSON:
- **URL**: `http://localhost:8080/v3/api-docs`

## Validaciones

El sistema implementa las siguientes validaciones de negocio:

1. **Nombre no nulo o vacío**: El nombre del artista no puede ser nulo o estar vacío
2. **Longitud mínima**: El nombre debe tener al menos 3 caracteres
3. **Unicidad**: No puede existir más de un artista con el mismo nombre

## Manejo de Errores

La API devuelve los siguientes códigos de estado:

- **200 OK**: Solicitud exitosa
- **201 Created**: Recurso creado exitosamente
- **400 Bad Request**: Error de validación (nombre inválido)
- **409 Conflict**: Intento de crear artista duplicado

## Estructura del Proyecto

```
src/main/java/com/fp/artista_hexagonal/artist/
├── application/
│   ├── ArtistaUseCase.java
│   └── exception/
│       ├── ArtistaDuplicadoException.java
│       └── ArtistaInvalidoException.java
├── configuration/
│   └── BeanConfiguration.java
├── domain/
│   ├── model/
│   │   └── Artista.java
│   └── port/
│       └── ArtistaRepositoryPort.java
└── infraestructure/
    ├── controller/
    │   └── ArtistaController.java
    └── repository/
        └── ArtistaRepositoryMemoriaAdapter.java
```

## Desarrollo

### Agregar nuevas funcionalidades

1. **Dominio**: Define nuevas entidades y puertos si es necesario
2. **Aplicación**: Implementa los casos de uso y validaciones
3. **Infraestructura**: Crea los adaptadores y controladores correspondientes

### Testing

Para ejecutar los tests unitarios:
```bash
mvn test
```

Para ejecutar tests con cobertura:
```bash
mvn jacoco:report
```

## Configuración

El archivo de configuración principal se encuentra en:
- `src/main/resources/application.properties`

## Contribución

1. Fork del proyecto
2. Crear una rama feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit de los cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crear un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para detalles.

## Contacto

- **Desarrollador**: [Tu Nombre]
- **Email**: [tu.email@ejemplo.com]
- **LinkedIn**: [Tu perfil de LinkedIn]

## Changelog

### v1.0.0
- Implementación inicial de la arquitectura hexagonal
- CRUD básico de artistas
- Validaciones de negocio
- Documentación con Swagger
- Manejo de excepciones
