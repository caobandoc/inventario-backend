@echo off
setlocal enabledelayedexpansion

echo Ejecutando tarea de despliegue en docker

set projects=eureka gateway auth products shoppingcart

for %%p in (%projects%) do (
    echo Desplegando proyecto %%p
    if not exist %%p (
        echo Error: El directorio %%p no existe.
        exit /b 1
    )
    cd %%p
    if not exist %%p.bat (
        echo Error: El archivo %%p.bat no se encuentra en el directorio %%p.
        cd ..
        exit /b 1
    )
    call %%p.bat
    if errorlevel 1 (
        echo Error al compilar proyecto %%p
        cd ..
        exit /b 1
    )
    cd ..
)

echo "Despliegue exitosa"
endlocal