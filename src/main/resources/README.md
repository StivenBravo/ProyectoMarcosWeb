# Sistema de Gestión de Libros

Este proyecto es una aplicación web desarrollada con **Spring Boot + Thymeleaf + MySQL** para gestionar libros y categorías.
Con proyeccion a futuro de poder ser un catálogo para usuarios y qué siga su funcionalidad 
## ¿Qué hace?

- Registrar libros con título, autor, año y categoría.
- Registrar y editar categorías.
- Ver todos los libros registrados.
- Eliminar libros y categorías.
- Muestra Formularios de Contacto
## Tecnologías usadas

- Java 17
- Spring Boot 3.x
- Thymeleaf
- MySQL
- Bootstrap 5

---

## Endpoints principales

| Método | Ruta            | Descripción                       |
|--------|------------------|-----------------------------------|
| GET    | `/libros`        | Lista y formulario de libros      |
| POST   | `/libros/guardar`| Guarda un libro                  |
| GET    | `/libros/editar/{id}` | Editar libro                  |
| GET    | `/libros/eliminar/{id}` | Eliminar libro             |
| GET    | `/categorias`    | Lista y formulario de categorías |
| POST   | `/categorias/guardar` | Guarda categoría             |
| GET    | `/categorias/editar/{id}` | Editar categoría         |
| GET    | `/categorias/eliminar/{id}` | Eliminar categoría     |

## Estructura del modelo (entidades)

### `Libro`
- `id: Long`
- `titulo: String`
- `autor: String`
- `anio: Integer`
- `categoria: Categoria` → relación `@ManyToOne`

### `Categoria`
- `id: Long`
- `nombre: String`
- `libros: List<Libro>` → relación `@OneToMany(mappedBy = "categoria")`

### `Formulario`
- `nombre: String`
- `id : Long`
- `edad : int `
- `correo : String`


---

## Estructura del proyecto (paquetes)
├── Controller/
│   ├── CategoriaController.java
│   ├── FormularioController.java
│   └── LibroController.java

├── Entitys/
│   ├── Categoria.java
│   ├── Formulario.java
│   └── Libro.java

├── Repositories/
│   ├── CategoriaRepository.java
│   ├── FormularioRepository.java
│   └── LibroRepository.java

├── MiLibreriaApplication.java

---
## Capturas de pantalla
REGISTRO LIBROS![Captura de pantalla (139).png](../java/com/libreria/miLibreria/Capturas/Captura%20de%20pantalla%20%28139%29.png)
![Captura de pantalla (140).png](../java/com/libreria/miLibreria/Capturas/Captura%20de%20pantalla%20%28140%29.png)
![Captura de pantalla (141).png](../java/com/libreria/miLibreria/Capturas/Captura%20de%20pantalla%20%28141%29.png)

FORMULARIOS DE CONTACTO 
![Captura de pantalla (142).png](../java/com/libreria/miLibreria/Capturas/Captura%20de%20pantalla%20%28142%29.png)

REGISTRO DE CATEGORIAS
![Captura de pantalla (143).png](../java/com/libreria/miLibreria/Capturas/Captura%20de%20pantalla%20%28143%29.png)
![Captura de pantalla (144).png](../java/com/libreria/miLibreria/Capturas/Captura%20de%20pantalla%20%28144%29.png)