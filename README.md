# 📦  Bienvenido al Repositorio de MensajeriaExpress

![image](https://github.com/jsblandonm/MensajeraExpress/assets/116750999/02c48f02-335a-4fcc-ac2c-1b52f5482495)


Este proyecto esta diseñada en el marco de un proyecto integrador para el Botcamp de Backend de Makaia como resultado de una correcta implemetnacion de los conocimientos  adquiridos en la formacion.

## Descripción del Proyecto
Es una plataforma de mensajería de paquetes diseñada para facilitar la entrega segura y eficiente de envíos. Permite a los usuarios enviar y rastrear paquetes, así como acceder a detalles completos de envíos y gestionar su logística de manera eficaz.

Este proyecto es una API REST diseñada para un sistema de mensajería de paquetes que permite a los clientes enviar y recibir paquetes a través de una interfaz.

📊📈 Diagramas:

![image](https://github.com/jsblandonm/MensajeraExpress/assets/94935847/cc88201b-b721-4ad5-9ca4-6fdd06374b46)

![image](https://github.com/jsblandonm/MensajeraExpress/assets/94935847/e02f4874-f3fc-4dba-9c06-f1fdf2f68330)



## Tecnologías Utilizadas

- **Lenguaje:** Java, versión 17 🚀
- **Framework:** Spring Boot 🌱
- **API RESTful con Spring MVC 🌐**
- **H2 Database y MySQL 🛢️**
- **Maven 🧰**
- **Lombok ⚙️**
- **Spring Boot Starter Data JPA y Spring Boot Starter Web 🔄**
- **Spring Boot Starter Test 🧪**
- **JUnit Jupiter API 🧾**
- **Spring Boot Test 🛠️**
- **Mockito JUnit Jupiter 🃏**
- **Spring Boot Starter Security 🔒**
  
Este conjunto de tecnologías ofrece un entorno sólido y eficiente para el desarrollo de envíos de paquetes con Spring Boot, asegurando calidad, mantenibilidad y escalabilidad del proyecto.

### Antes de Comenzar

Asegúrate de tener las siguientes herramientas y dependencias instaladas antes de ejecutar la aplicación:

- Java JDK
- Maven
- MySQL

  
## Instalación

1. Clona el repositorio: `git clone tps://github.com/jsblandonm/MensajeraExpress`
2. Abre el proyecto con tu IDE preferido (Eclipse, IntelliJ, etc.).
3. Configura el archivo `application.properties` en la ruta `src/main/resources` para conectarte a la base de datos MySQL o H2 en memoria. Puedes dejar la configuración por defecto o cambiarla según tus necesidades.
4. Ejecuta el comando `mvn clean install` para descargar las dependencias del proyecto y compilarlo.
5. Ejecuta el comando `mvn spring-boot:run` para iniciar la aplicación.
Tecnologías

## 💻 Endpoints:

## Endpoint de creación de cliente 🙋

## POST:  http://localhost:8080/clientes

##### Parámetros de entrada:

- cedula: Cédula del cliente (número entero)
- nombre: Nombre del cliente (cadena de texto)
- apellido: Apellido del cliente (cadena de texto)
- celular: Número de celular del cliente (cadena de texto)
- email: Dirección de correo electrónico del cliente (cadena de texto)
- dirResidencia: Dirección de residencia del cliente (cadena de texto)
- ciudad: Ciudad de residencia del cliente (cadena de texto)

Ejemplo de solicitud:

```java 
{
"cedula": Integer,
"nombre": String,
"apellido": String,
"celular": "String",
"email": "String",
"direccionResidencia": "String",
"ciudad": "String"
}
```
La API devolverá el nuevo cliente creado en formato JSON:

```java 
{
  "cedula": 12345678,
  "nombre": "Sebastian",
  "apellido": "Blandon",
  "celular": "3165778789",
  "email": "sebastian123@mail.com",
  "direccionResidencia": "av12-34",
  "ciudad": "Medellin"
}
```
### GET: http://localhost:8080/clientes/(cedula)

 🕵 Este endpoint permite  **buscar** un cliente por cédula, es una funcionalidad que permite a los usuarios obtener los datos de un cliente en particular utilizando su número de identificación.

##### Parámetros de entrada:

- cedula: cedula del cliente (numero)

Ejemplo de solicitud:

```(http://localhost:8080/clientes/12345678)```

La API devolverá el cliente encontrado en formato JSON:
```java 
{
  "cedula": 12345678,
  "nombre": "Sebastian",
  "apellido": "Blandon",
  "celular": "3165778789",
  "email": "sebastian123@mail.com",
  "direccionResidencia": "av12-34",
  "ciudad": "Medellin"
}
```
### PUT: http://localhost:8080/clientes/{cedula}

♻ Este endpoint permite  **actualizar** los datos de un cliente es una funcionalidad que permite a los usuarios modificar la información de un cliente existente en la base de datos.

##### Parámetros de entrada:

- cedula: Cédula del cliente (número entero)
- nombre: Nombre del cliente (cadena de texto)
- apellido: Apellido del cliente (cadena de texto)
- celular: Número de celular del cliente (cadena de texto)
- email: Dirección de correo electrónico del cliente (cadena de texto)
- dirResidencia: Dirección de residencia del cliente (cadena de texto)
- ciudad: Ciudad de residencia del cliente (cadena de texto)

Ejemplo de solicitud:

```(http://localhost:8080/clientes/12345678)```
```java 
{
"cedula": Integer,
"nombre": String,
"apellido": String,
"celular": "String",
"email": "String",
"direccionResidencia": "String",
"ciudad": "String"
}
```

La API devolverá el cliente actualizado en formato JSON:
```java 
{
  "cedula": 12345678,
  "nombre": "Sebastian",
  "apellido": "Yatra",
  "celular": "3165778789",
  "email": "sebastian123@mail.com",
  "direccionResidencia": "calle 59-18",
  "ciudad": "Medellin"
}
```

## Contribuir

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama con la funcionalidad que deseas agregar.
3. Realiza tus cambios.
4. Haz un pull request hacia la rama principal del repositorio.

## Licencia
Este proyecto está bajo la Licencia MIT - mira el archivo LICENSE.md para más detalles.

