FROM openjdk:17-jdk-alpine3.14
LABEL authors="CAOBANDOC"

WORKDIR /app

COPY build/libs/gateway-0.0.1-SNAPSHOT.jar /app/gateway-service.jar

ENV EUREKA_HOST=host.docker.internal
ENV EUREKA_PORT=8761

EXPOSE 8000

CMD ["java", "-jar", "gateway-service.jar"]