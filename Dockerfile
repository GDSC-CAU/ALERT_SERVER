# Docker file for building the image

# jdk 17
FROM openjdk:17

ENV DB_URL=${DB_URL} \
    DB_USERNAME=${DB_USERNAME} \
    DB_PASSWORD=${DB_PASSWORD} \
    JWT_SECRET=${JWT_SECRET}

# Copy the jar file to the container
ARG JAR_FILE=build/libs/*.jar
# jar file Copy
COPY ${JAR_FILE} app.jar
COPY serviceAccountKey.json serviceAccountKey.json

ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar","app.jar"]
