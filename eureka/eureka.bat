@echo off

docker build -t eureka-server:0.0.1 .
docker run -d -p 8761:8761 --name eureka eureka-server:0.0.1 