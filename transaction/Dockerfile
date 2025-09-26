# Etapa de construcción
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn -pl transaction -am clean package -DskipTests

# Etapa de ejecución
FROM registry.access.redhat.com/ubi9/openjdk-21
WORKDIR /app

# Copiar el jar del submódulo
COPY --from=builder /app/transaction/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
