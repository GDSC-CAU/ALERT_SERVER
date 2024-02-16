# Docker file for building the image

# jdk 17
FROM openjdk:17

# Copy the jar file to the container
ARG JAR_FILE=build/libs/*.jar
# jar file Copy
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar","app.jar"]
