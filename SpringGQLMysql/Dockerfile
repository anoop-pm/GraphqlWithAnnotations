# Start with an official OpenJDK image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the project’s jar file into the container at /app
COPY target/SpringGQLMysql-0.0.1-SNAPSHOT.jar /app/SpringGQLMysql-0.0.1-SNAPSHOT.jar

# Expose port 8080 (the default port for Spring Boot applications)
EXPOSE 8080

# Set the default command to run your jar file
ENTRYPOINT ["java", "-jar", "SpringGQLMysql-0.0.1-SNAPSHOT.jar"]
