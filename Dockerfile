FROM openjdk:12

WORKDIR /app
ARG JAR_FILE
ADD ${JAR_FILE} /app/best-practises.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/app/best-practises.jar"]