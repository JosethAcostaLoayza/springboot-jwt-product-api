🛠️ springboot-jwt-product-api
📋 Descripción
API RESTful desarrollada con Java y Spring Boot, que implementa:

- 🔐 Autenticación segura con JWT
- 📦 CRUD completo para la entidad `Product` (`id`, `name`, `price`)
- 🧱 Buenas prácticas de arquitectura en capas
- 📑 Documentación interactiva con Swagger / OpenAPI 3

🚀 Tecnologías utilizadas
- Java 17
- Spring Boot 3
- Spring Security
- JWT (Json Web Token)
- Spring Data JPA
- H2 Database (puede cambiarse a MySQL/PostgreSQL)
- Springdoc OpenAPI
- Lombok
- Postman (para pruebas)

📦 Endpoints principales
| Método | Ruta                      | Función                 | Autenticación |
|--------|---------------------------|--------------------------|---------------|
| POST   | `/api/auth/login`         | Login y generación de JWT | ❌ Pública     |
| GET    | `/api/products`           | Listar productos         | ✅ Requiere JWT |
| POST   | `/api/products`           | Crear producto           | ✅ Requiere JWT |
| PUT    | `/api/products/{id}`      | Editar producto          | ✅ Requiere JWT |
| DELETE | `/api/products/{id}`      | Eliminar producto        | ✅ Requiere JWT |

🔐 Autenticación JWT
Después de hacer login en POST /api/auth/login, obtendrás un token JWT.
Usa este token para acceder a los endpoints protegidos, agregándolo al header:
Authorization: Bearer <tu_token_jwt>

📘 Documentación de la API
Accede a la interfaz Swagger UI en:
http://localhost:8080/swagger-ui.html
o
http://localhost:8080/swagger-ui/index.html

▶️ Cómo ejecutar el proyecto
Clona el repositorio:
git clone https://github.com/tu-usuario/springboot-jwt-product-api.git
cd springboot-jwt-product-api

Ejecuta el proyecto:
./mvnw spring-boot:run

Asegúrate de tener Java 17 y Maven instalados.

🧪 Pruebas con Postman
Importa la colección:
📁 springboot-product-api.postman_collection.json
Incluye login y todas las operaciones CRUD.
Usa el token JWT generado en /api/auth/login y pégalo en la variable jwt_token.

🧾 Estructura del proyecto
src
└── main
    ├── java/com/tuempresa/productapi
    │   ├── controller
    │   ├── dto
    │   ├── entity
    │   ├── repository
    │   ├── security
    │   └── service
    └── resources
        └── application.properties
        
📄 Licencia
Este proyecto está bajo licencia MIT.
¡Libre de usar, modificar y compartir!
