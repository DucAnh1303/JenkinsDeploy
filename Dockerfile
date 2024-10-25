FROM gradle:7.6.1-jdk17-alpine AS build

WORKDIR /app

COPY . /app

RUN ./gradlew clean build

FROM openjdk:17-slim

COPY /build/libs/jenkins-0.0.1-SNAPSHOT.jar /app/jenkins.jar

ENTRYPOINT ["java", "-jar", "/app/jenkins.jar"]