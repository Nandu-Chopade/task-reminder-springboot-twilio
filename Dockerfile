# Use OpenJDK 17 slim as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the generated JAR file
COPY ./target/task-manager-0.0.1-SNAPSHOT.jar /app/task-manager.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/task-manager.jar"]
