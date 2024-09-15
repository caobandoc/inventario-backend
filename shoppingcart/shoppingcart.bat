@echo off

docker build -t shoppingcart-service:0.0.1 .
docker run -d -p 8003:8003 --network inventory --name shoppingcart shoppingcart-service:0.0.1