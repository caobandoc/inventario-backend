@echo off

docker build -t products-service:0.0.1 .
docker run -d -p 8002:8002 --network inventory --name products products-service:0.0.1