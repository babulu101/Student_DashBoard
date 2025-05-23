# Use a base image with JDK
FROM openjdk:17-jdk-alpine

# Set application JAR name
ARG JAR_FILE=target/*.jar

# Copy JAR into container
COPY ${JAR_FILE} app.jar

# Expose the port (same as in application.properties)
EXPOSE 2727

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]
