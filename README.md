# API-Rest-Bazar-Springboot

## Descripción

**API-Rest-Bazar-Springboot** es una API RESTful desarrollada con Spring Boot para gestionar un sistema de bazar. Esta API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre diversos recursos del sistema, como productos, clientes y órdenes de compra.

## Características

-   Gestión de productos: creación, actualización, eliminación y consulta.
-   Gestión de clientes: creación, actualización, eliminación y consulta.
-   Gestión de órdenes de compra: creación, actualización, eliminación y consulta.
-   Autenticación y autorización con JWT.
-   Validación de datos de entrada.
-   Manejo de excepciones personalizado.

## Tecnologías

-   Java 11+
-   Spring Boot 2.5.0
-   Spring Security
-   Spring Data JPA
-   Hibernate
-   MySQL
-   Maven

## Uso

Una vez que la aplicación esté en ejecución, puedes acceder a la API utilizando herramientas como `curl`, `Postman` o directamente desde tu aplicación frontend.

### Ejemplos de Endpoints

-   **GET /api/products**: Obtiene todos los productos.
-   **POST /api/products**: Crea un nuevo producto.
-   **GET /api/products/{id}**: Obtiene un producto por ID.
-   **PUT /api/products/{id}**: Actualiza un producto por ID.
-   **DELETE /api/products/{id}**: Elimina un producto por ID.
