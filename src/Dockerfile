#creamos un dockerfile multi-stage build, o sea que usa una imagen para compilar y otra mas liviana para solo ejecutar, así la final pesa menos :D

#usamos una imagen base con maven y java 21 para compilar
FROM maven:3.9.6-eclipse-temurin-21 AS build

#definimos el directorio de trabajo dentro del contenedor
WORKDIR /app

#copiamos el pom primero para aprovechar el cache de dependencias
COPY pom.xml .

#descargamos las dependencias
RUN mvn dependency:go-offline

#copiamos el resto de código
COPY src ./src

#compilamos y empaquetamos el proyecto en un .jar
RUN mvn clean package -DskipTest

#segunda imagen mas liviana
FROM eclipse-eclipse-temurin:21-jre

WORKDIR /app

#copiamos el .jar anterior
COPY --from=build /app/target/*.jar app.jar

#exponemos el puerto 8080
EXPOSE 8080

#ejecutamos la app
ENTRYPOINT ["java", "-jar", "app.jar"]
