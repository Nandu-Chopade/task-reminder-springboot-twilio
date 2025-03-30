# 1️⃣ OpenJDK 17 बेस इमेज वापरतोय
FROM openjdk:17-jdk-slim

# 2️⃣ Container साठी Work Directory Set करतोय
WORKDIR /app

# 3️⃣ Target मधील JAR File ला योग्य नावाने कॉपी करतोय
COPY target/task-manager-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Environment Variable (Optional)
ENV SPRING_PROFILES_ACTIVE=docker

# 5️⃣ Port Expose करतोय
EXPOSE 8080

# 6️⃣ Application चालवतोय
ENTRYPOINT ["java", "-jar", "app.jar"]
