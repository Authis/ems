
FROM maven:3.8.6-openjdk-18 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:18-jdk-slim-buster
COPY --from=build app/target/ems-0.0.1-SNAPSHOT.jar app/
WORKDIR /app
ENTRYPOINT java -jar ems-0.0.1-SNAPSHOT.jar