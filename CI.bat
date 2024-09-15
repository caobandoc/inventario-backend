@echo off
setlocal enabledelayedexpansion

echo Ejecutando tarea de compilacion

set projects=eureka gateway auth products shoppingcart

for %%p in (%projects%) do (
    echo Compilando proyecto %%p
    if not exist %%p (
        echo Error: El directorio %%p no existe.
        exit /b 1
    )
    cd %%p
    if not exist gradlew (
        echo Error: El archivo gradlew no se encuentra en el directorio %%p.
        cd ..
        exit /b 1
    )
    call gradlew clean build -x test
    if errorlevel 1 (
        echo Error al compilar proyecto %%p
        exit /b 1
    )
    cd ..
)

echo "Compilacion exitosa"
endlocal