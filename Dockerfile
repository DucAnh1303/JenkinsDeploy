FROM gradle:7.6.1-jdk17-alpine AS build

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew && ./gradlew clean build -x test

FROM openjdk:17-slim

COPY --from=build /app/build/libs/jenkins-0.0.1-SNAPSHOT.jar /app/jenkins.jar

EXPOSE 9091

ENTRYPOINT ["java", "-jar", "/app/jenkins.jar"]