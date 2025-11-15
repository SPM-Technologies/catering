@echo off
echo ============================================
echo   Maven Quick Installer for Windows
echo ============================================
echo.
echo This script will download and install Maven.
echo.
pause

REM Check if running as Administrator
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo ERROR: This script must be run as Administrator!
    echo Right-click and select "Run as administrator"
    pause
    exit /b 1
)

echo [1/5] Checking Java installation...
java -version >nul 2>&1
if %errorLevel% neq 0 (
    echo ERROR: Java is not installed!
    echo Please install Java 21 from: https://adoptium.net/
    pause
    exit /b 1
)
echo    ✓ Java is installed

echo.
echo [2/5] Downloading Maven...
powershell -Command "& {Invoke-WebRequest -Uri 'https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip' -OutFile '%TEMP%\maven.zip'}"
if %errorLevel% neq 0 (
    echo ERROR: Download failed!
    pause
    exit /b 1
)
echo    ✓ Maven downloaded

echo.
echo [3/5] Extracting Maven...
powershell -Command "& {Expand-Archive -Path '%TEMP%\maven.zip' -DestinationPath 'C:\Program Files\Apache' -Force}"
if exist "C:\Program Files\Apache\apache-maven-3.9.6" (
    echo    ✓ Maven extracted
) else (
    echo ERROR: Extraction failed!
    pause
    exit /b 1
)

echo.
echo [4/5] Setting environment variables...
setx MAVEN_HOME "C:\Program Files\Apache\apache-maven-3.9.6" /M
setx PATH "%PATH%;C:\Program Files\Apache\apache-maven-3.9.6\bin" /M
echo    ✓ Environment variables set

echo.
echo [5/5] Cleaning up...
del "%TEMP%\maven.zip"
echo    ✓ Cleanup complete

echo.
echo ============================================
echo   Maven Installation Complete!
echo ============================================
echo.
echo IMPORTANT: Close this window and open a NEW Command Prompt
echo Then verify installation with: mvn --version
echo.
echo Next steps:
echo   1. Open NEW Command Prompt
echo   2. cd D:\Projects\GIT_Projects\catering
echo   3. mvn clean package
echo   4. mvn spring-boot:run
echo.
pause
