FROM openjdk:17-jdk-alpine3.14
LABEL authors="CAOBANDOC"

WORKDIR /app

COPY build/libs/shoppingcart-0.0.1-SNAPSHOT.jar shoppingcart-service.jar

ENV DB_HOST=host.docker.internal
ENV DB_PORT=3306
ENV EUREKA_HOST=host.docker.internal
ENV EUREKA_PORT=8761

EXPOSE 8003

CMD ["java", "-jar", "shoppingcart-service.jar"]