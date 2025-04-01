# **Alberto Alonso - Prueba Técnica Knowmad Mood**

## **Descripción**

Este proyecto consiste en una **API REST** desarrollada con **Spring Boot** y **Java 17**, siguiendo los principios de **Clean Architecture** y aplicando buenas prácticas de desarrollo.

La API expone un endpoint para obtener el **detalle de productos relacionados** a un producto dado por su **ID**. Para ello, realiza una llamada a una **API externa**, la cual se encuentra disponible a través de un **Docker Compose** proporcionado.

---


## **Características**

- **Clean Architecture:** Estructura modular y desacoplada, facilitando la integración y el mantenimiento del código.
- **Feign:** Comunicación con APIs externas utilizando el cliente Feign para simplificar las llamadas HTTP.
- **Swagger:** Documentación interactiva de la API para facilitar su uso y prueba mediante una interfaz web.
- **Docker:** Contenedorización del proyecto mediante Docker, permitiendo su ejecución en cualquier entorno.

---

## **Requisitos**

- **Java 17**: Es necesario tener instalado **Java 17** en el sistema.
- **Docker**: Es necesario tener instalado **Docker** en el equipo.
- **Puerto 5000:** El servicio requiere que el puerto **5000** esté libre para poder ejecutarse correctamente.

---

## **Instrucciones de Ejecución**

### **Opción A: Ejecutar desde el IDE**

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/AlbertoAlonsoMc/Prueba-Tecnica-Knowmad-Mood.git

2. **Levantar el docker-compose proporcionado en el enunciado de la prueba**
3. **Abrir, compilar y ejecutar el proyecto en el IDE.**
4. **Acceder a la API de Swagger mediante: http://localhost:5000/swagger-ui.html**

### **Opción B: Ejecutar con Docker**
1. **Levantar el docker-compose proporcionado en el enunciado de la prueba**
2. **Descargar la imagen desde Docker Hub:**
   ```bash
   docker pull albertoalonsomc/prueba-tecnica-knowmad-mood

3. **Ejecutar el contenedor de Docker.**
    ```bash
   docker run --name prueba-tecnica-knowmad-mood -p 5000:5000 albertoalonso/prueba-tecnica-knowmad-mood

4. **Acceder a la API de Swagger mediante: http://localhost:5000/swagger-ui.html**

---

## **Conexión entre contenedores**
Si tras seguir las instrucciones de ejecución, el endpoint no encuentra valores, es bastante probable que los contenedores se encuentren en networks distintas. Para solucionarlo:

1. **Inspeccionar las networks existentes:**
   ```bash
   docker network ls

2. **Buscar la network asociada al docker-compose.**
3. **Conectar el contenedor a la misma network:**
   ```bash
   docker network connect <nombre_red> prueba-tecnica-knowmad-mood

(Asegurarse de reemplazar <nombre_red> por el nombre de la network correspondiente).
