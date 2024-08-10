# Start with a Gradle image that includes JDK 17
FROM gradle:7.5.1-jdk17 AS build

WORKDIR /app

COPY gradle /app/gradle
COPY build.gradle settings.gradle /app/

COPY src /app/src


RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar","--spring.profiles.active=prod"]