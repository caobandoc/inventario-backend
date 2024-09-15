# inventario-backend

## Descripción del Proyecto

Este proyecto consiste en un sistema de microservicios que permiten gestionar un inventario de productos. Los microservicios que conforman el sistema son los siguientes:

- **gateway**: Permite gestionar las peticiones de los clientes y redirigirlas a los microservicios correspondientes.
- **auth**: Permite gestionar la autenticación, autorizacion y control de los usuarios.
- **product**: Permite gestionar los productos del inventario.
- **shoppingcart**: Permite gestionar los carritos de compra de los usuarios.

## Requisitos Mínimos

Para ejecutar este proyecto, necesitas tener los siguientes requisitos mínimos:

- **Software**:
  - Docker
  - PowerShell (para ejecutar scripts de PowerShell si es necesario)
  - Git (opcional, para clonar el repositorio)


## Despliegue del Proyecto

Para desplegar el proyecto, sigue estos pasos:

1. **Clonar el repositorio** (si aún no lo has hecho):

   ```sh
   git clone https://github.com/tu-usuario/inventario-backend.git
   cd inventario-backend
    ```

2. **Configurar la red de Docker**:

    Abre un terminal de comandos y ejecuta el siguiente comando:
    
    ```sh
    docker network create inventory
    ```

3. **Configurar base de datos**:

    Abre un terminal de comandos y navega al directorio del proyecto. Luego, ejecuta el siguiente script:
    
    ```sh
    docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret -network inventory mysql
    ```

    Luego, ejecuta el script que se encuentra dentro de la carpeta BD/schema.sql para crear la base de datos y las tablas necesarias.

5. **Copilar los microservicios**:

    Abre un terminal de comandos y navega al directorio del proyecto. Luego, ejecuta el siguiente script:
      
      ```sh
      CI.bat
      ```

    Este ejecutará el script de compilación para todos los microservicios.

6. **Desplegar los microservicios**:

    Abre un terminal de comandos y navega al directorio del proyecto. Luego, ejecuta el siguiente script:
    
    ```sh
    docker-compose up
    ```

    Este comando desplegará todos los microservicios en contenedores de Docker.

7. **Probar la aplicación**:

    En la raiz del producto se encuentra un archivo llamado `Inventario.postman_collection.json` que contiene una colección de Postman con las peticiones necesarias para probar la aplicación.