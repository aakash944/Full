# Use Apache Beam Java 11 SDK as base image
FROM apache/beam_java11_sdk

# Set working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR from the project folder
COPY demo/target/*.jar app.jar

# Optional: copy source code for inspection/debug
COPY demo/src /app/src

# Expose Spring Boot default port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
