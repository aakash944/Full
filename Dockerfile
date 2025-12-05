# Use Apache Beam Java 11 SDK as base image
FROM apache/beam_java11_sdk

# Set working directory inside the container
WORKDIR /app

# Copy your Spring Boot JAR
COPY demo/demo/target/*.jar app.jar

# Copy your source code (optional, for inspection inside container)
COPY demo/demo/src /app/src

# Expose Spring Boot default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
