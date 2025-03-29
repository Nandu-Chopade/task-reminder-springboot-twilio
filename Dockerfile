# Step 1: Build Stage (Uses Maven to Build JAR)
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy entire source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run Stage (Uses OpenJDK 17 slim)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/task-manager-0.0.1-SNAPSHOT.jar /app/task-manager.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/task-manager.jar"]
