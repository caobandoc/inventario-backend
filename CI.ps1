# Continues_Integration.ps1

$projects = @("eureka", "gateway", "auth", "products", "shoppingcart")

foreach ($project in $projects) {
    Write-Host "Compilando proyecto $project"
    
    if (-Not (Test-Path $project)) {
        Write-Host "Error: El directorio $project no existe."
        exit 1
    }
    
    Set-Location $project
    
    if (-Not (Test-Path "./gradlew")) {
        Write-Host "Error: El archivo gradlew no se encuentra en el directorio $project."
        Set-Location ..
        exit 1
    }
    
    & ./gradlew clean build -x test
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Error al compilar proyecto $project"
        exit 1
    }
    
    Set-Location ..
}

Write-Host "Compilacion exitosa"