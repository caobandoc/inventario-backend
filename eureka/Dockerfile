FROM openjdk:17-jdk-alpine3.14
LABEL authors="CAOBANDOC"

WORKDIR /app

COPY build/libs/eureka-0.0.1-SNAPSHOT.jar /app/eureka-server.jar

EXPOSE 8761

CMD ["java", "-jar", "eureka-server.jar"]