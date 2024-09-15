#!/bin/bash

projects=("eureka" "gateway" "auth" "products" "shoppingcart")

for project in "${projects[@]}"; do
    echo "Compilando proyecto $project"
    
    if [ ! -d "$project" ]; then
        echo "Error: El directorio $project no existe."
        exit 1
    fi
    
    cd "$project"
    
    if [ ! -f "./gradlew" ]; then
        echo "Error: El archivo gradlew no se encuentra en el directorio $project."
        cd ..
        exit 1
    fi
    
    ./gradlew clean build -x test
    if [ $? -ne 0 ]; then
        echo "Error al compilar proyecto $project"
        exit 1
    fi
    
    cd ..
done

echo "Compilacion exitosa"