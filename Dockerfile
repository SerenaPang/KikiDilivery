FROM eclipse-temurin:22-jdk-alpine
WORKDIR /app
COPY target/kikidiliveryApi-0.0.1-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]
