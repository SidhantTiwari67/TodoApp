# Stage 1: Build the application using Gradle wrapper
FROM openjdk:19-slim AS build
WORKDIR /app
COPY . .
RUN ./gradlew build -x test

# Stage 2: Run the application
FROM openjdk:19-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
