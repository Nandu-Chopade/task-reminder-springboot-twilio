# 1. Base Image (JDK 17 वापरतोय)
FROM openjdk:17-jdk-slim

# 2. Work directory सेट करा
WORKDIR /app

# 3. Dependencies install करून application build करा
COPY ./target/task-reminder.jar /app/task-reminder.jar

# 4. कंटेनर रन करताना हे कमांड चालवा
ENTRYPOINT ["java", "-jar", "/app/task-reminder.jar"]
