FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/app/app.jar"]