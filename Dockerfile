FROM maven:3.9.6-amazoncorretto-21

ARG JAR_FILE=target/*.jar

RUN java --version

COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
