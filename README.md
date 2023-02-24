# Calculadora API
![](https://img.shields.io/badge/Java11-orange.svg)
![](https://img.shields.io/badge/Spring%20Boot-2.7.8-green.svg)

La API de la calculadora básica es la solución propuesta a la prueba técnica de Spring Boot para Sanitas.
Se han implementado las interacciones básicas de suma, resta, multiplicación y división entre dos operadores.

## Contenido del repositorio
- Uso de `maven` con `SpringBoot`
- Documentación con `Swagger` e interfaz de usuario con `Swagger-ui`
- Utiliza `Junit` para test unitarios
- `HandlerException` para controlar y personalizar excepciones

## Descripción
Se ha llevado a cabo la implementación de la API de una calculadora básica utilizando Spring Boot 2.7.8, Java 11, Maven 3.6.3.

La aplicación permite sumar dos operadores
> GET http://localhost:8080/calculadora/sum/200/3

Restar dos operadores:
> GET http://localhost:8080/calculadora/sub/2/3

Multiplicar dos operadores:
> GET http://localhost:8080/calculadora/mult/2/3

Dividir dos operadores. Si el segundo operador es menor que 1, se muestra una excepción "Please, check that the second operator is greater than zero to perform the division"
> GET http://localhost:8080/calculadora/div/2/3

## Instalación y ejecución
Para su instalación seguir los siguiente pasos:

1. Descargar el proyecto desde github y descomprimirlo: 
[Github](https://github.com/jcubillosm/Calculadora "Repositorio")

2. Desde una terminal ir hasta el directorio donde se encuentra el pom.xml del proyecto y ejecutar uno de los siguientes comandos:

2.1. Para compilar sin test
```sh 
mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0 -Dpackaging=jar package -Dmaven.test.skip=true
```

2.2. Para compilar con test
```sh 
mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0 -Dpackaging=jar package
```

3. Después de la compilación, permaneciendo en la misma carpeta donde se encuentra el pom.xml ejecutar el comando 
```sh 
mvn spring-boot:run
```

4. Abrir un navegador y lanzar una consulta que tenga la estructura: http://localhost:8080/calculadora/{operacion}/{primer_operador}/{segundo_operador}
Las operaciones disponibles {operacion} son: sum, sub, mult, div.
La api acepta números enteros y decimales, {primer_operador} y {segundo_operador}

Por ejemplo:
> http://localhost:8080/calculadora/sum/200/3.5

## Documentacion
La api hace uso de un swagger para exponer la documentación en la siguiente url:
[Swagger](http://localhost:8080/swagger-ui/index.html "Swagger")
