@echo off
REM ============================================
REM   Complete Environment Setup
REM   Installs: Chocolatey + Maven + Java
REM ============================================

REM Check for admin privileges
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo ============================================
    echo   REQUESTING ADMINISTRATOR PRIVILEGES
    echo ============================================
    echo.
    echo This script needs administrator privileges.
    echo Please approve the UAC prompt...
    echo.
    
    REM Re-run as administrator
    powershell -Command "Start-Process '%~f0' -Verb RunAs"
    exit /b
)

cls
echo ============================================
echo   COMPLETE DEVELOPMENT ENVIRONMENT SETUP
echo   Calculator Web Application
echo ============================================
echo.
echo This will install:
echo   [1] Chocolatey (Package Manager)
echo   [2] Java 21 (OpenJDK)
echo   [3] Apache Maven 3.9.6
echo.
echo Time required: 5-10 minutes
echo.
pause

REM ============================================
REM Install Chocolatey
REM ============================================
echo.
echo ============================================
echo [STEP 1/3] Installing Chocolatey
echo ============================================
echo.

where choco >nul 2>&1
if %errorLevel% equ 0 (
    echo Chocolatey is already installed!
) else (
    echo Installing Chocolatey...
    @"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "[System.Net.ServicePointManager]::SecurityProtocol = 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"
    
    if %errorLevel% neq 0 (
        echo ERROR: Chocolatey installation failed!
        pause
        exit /b 1
    )
    echo ✓ Chocolatey installed successfully!
)

REM Refresh environment
call refreshenv >nul 2>&1

REM ============================================
REM Install Java 21
REM ============================================
echo.
echo ============================================
echo [STEP 2/3] Installing Java 21
echo ============================================
echo.

java -version >nul 2>&1
if %errorLevel% equ 0 (
    echo Java is already installed!
    java -version
) else (
    echo Installing Java 21 OpenJDK...
    choco install openjdk21 -y
    
    if %errorLevel% neq 0 (
        echo ERROR: Java installation failed!
        pause
        exit /b 1
    )
    echo ✓ Java 21 installed successfully!
)

REM Refresh environment
call refreshenv >nul 2>&1

REM ============================================
REM Install Maven
REM ============================================
echo.
echo ============================================
echo [STEP 3/3] Installing Apache Maven
echo ============================================
echo.

mvn -version >nul 2>&1
if %errorLevel% equ 0 (
    echo Maven is already installed!
    mvn -version
) else (
    echo Installing Apache Maven...
    choco install maven -y
    
    if %errorLevel% neq 0 (
        echo ERROR: Maven installation failed!
        pause
        exit /b 1
    )
    echo ✓ Maven installed successfully!
)

REM ============================================
REM Verify Installation
REM ============================================
echo.
echo ============================================
echo [VERIFICATION] Checking Installations
echo ============================================
echo.

REM Refresh environment one more time
call refreshenv >nul 2>&1

echo Checking Java...
java -version 2>&1 | findstr /C:"openjdk"
if %errorLevel% equ 0 (
    echo ✓ Java is working
) else (
    echo ✗ Java verification failed
)

echo.
echo Checking Maven...
mvn -version 2>&1 | findstr /C:"Apache Maven"
if %errorLevel% equ 0 (
    echo ✓ Maven is working
) else (
    echo ✗ Maven verification failed
)

REM ============================================
REM Complete
REM ============================================
echo.
echo ============================================
echo   INSTALLATION COMPLETE!
echo ============================================
echo.
echo Tools installed:
echo   ✓ Chocolatey Package Manager
echo   ✓ Java 21 OpenJDK
echo   ✓ Apache Maven 3.9.6
echo.
echo ============================================
echo   IMPORTANT: NEXT STEPS
echo ============================================
echo.
echo 1. CLOSE THIS WINDOW
echo 2. OPEN A NEW COMMAND PROMPT
echo 3. Navigate to project:
echo    cd D:\Projects\GIT_Projects\catering
echo.
echo 4. Build project:
echo    mvn clean package
echo.
echo 5. Run application:
echo    mvn spring-boot:run
echo.
echo 6. Open browser:
echo    http://localhost:8080/
echo.
echo ============================================
echo.
pause
