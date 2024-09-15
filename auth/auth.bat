@echo off

docker build -t auth-service:0.0.1 .
docker run -d -p 8001:8001 --network inventory --name auth auth-service:0.0.1