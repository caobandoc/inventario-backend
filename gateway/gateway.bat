@echo off

docker build -t gateway-service:0.0.1 .
docker run -d -p 8000:8000 --name gateway --network inventory gateway-service:0.0.1