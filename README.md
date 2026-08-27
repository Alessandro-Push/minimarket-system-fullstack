# 🛒 Minimarket System Fullstack

Sistema web de gestión integral para minimarkets diseñado para administrar de forma centralizada el inventario de productos, ventas y registro de clientes.

---

## 🏗️ Estructura del Proyecto

El repositorio está organizado en una arquitectura desacoplada que separa el cliente frontend de la API backend:

```text
minimarket-system-fullstack/
├── backend/    # API REST desarrollada en Spring Boot
└── frontend/   # Interfaz de usuario desarrollada en Angular
```

🚀 Tecnologías y Herramientas Utilizadas
---
## Backend (Spring Boot)
  - Java 17 & Spring Boot 3
  
  - Spring Data JPA / Hibernate: Mapeo objeto-relacional (ORM) para la persistencia de datos.
  
  - MySQL: Base de datos relacional para el almacenamiento de datos.
  
  - RESTful APIs: Controladores y endpoints para operaciones CRUD.
  
  - Maven: Gestión de dependencias y construcción del proyecto.

## Frontend (Angular)
  - Angular & TypeScript
  
  - RxJS: Manejo de programación reactiva y flujos de datos asíncronos (Observables).
  
  - HttpClient: Consumo de la API REST del backend.
  
  - Angular Router: Navegación entre vistas sin recarga de página (Single Page Application).
  
  - HTML5 / CSS3 / Bootstrap 5: Diseño web responsivo e interfaz dinámica.

⚙️ Módulos y Funcionalidades del Sistema
---
📦 1. Gestión de Productos e Inventario (CRUD)
  - Listado General: Muestra de productos con su información relevante (nombre, categoría, precio, stock disponible).
  
  - Registro y Edición: Formulación de datos para dar de alta nuevos productos o actualizar su información en tiempo real.
  
  - Eliminación de Registro: Borrado de productos del inventario con actualización inmediata en la vista.
  
  - Control de Stock: Monitoreo de existencias para evitar desabastecimiento.

👥 2. Gestión de Clientes
  - Mantenimiento de Clientes: Creación, actualización y consulta de perfiles de clientes.
  
  - Búsqueda Dinámica: Filtro ágil de clientes y productos dentro de la interfaz.

🔌 3. Integración Full Stack
  - Manejo de CORS: Configuración de seguridad en Spring Boot para permitir la comunicación segura entre el frontend (localhost:4200) y el backend (localhost:8080).
  
  - Inyección de Dependencias: Uso de servicios en Angular e interfaces Repository en Spring Boot para mantener un código limpio y desacoplado.
`
