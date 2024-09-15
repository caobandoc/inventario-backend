FROM openjdk:17-jdk-alpine3.14
LABEL authors="CAOBANDOC"

WORKDIR /app

COPY build/libs/auth-0.0.1-SNAPSHOT.jar /app/auth-service.jar

ENV DB_HOST=host.docker.internal
ENV DB_PORT=3306
ENV EUREKA_HOST=host.docker.internal
ENV EUREKA_PORT=8761

EXPOSE 8001

CMD ["java", "-jar", "auth-service.jar"]