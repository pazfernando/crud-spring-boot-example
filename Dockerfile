FROM amazoncorretto:17.0.11-alpine
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]