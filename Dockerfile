FROM openjdk:11

WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app/best-practises.jar

ENTRYPOINT ["java", "-jar", "/app/best-practises.jar"]