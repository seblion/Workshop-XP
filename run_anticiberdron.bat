@echo off
REM Script to rebuild and run the AntiCiberDron application
REM Author: KGD AntiCiberDron Team

echo [INFO] Building AntiCiberDron...
call mvn clean package
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Build failed. Please check the errors above.
    pause
    exit /b %ERRORLEVEL%
)

echo [INFO] Build successful. Starting application...
echo.
java -cp target/anticiberdron-1.0-SNAPSHOT.jar com.kgd.anticiberdron.controller.SistemaRuso
pause
