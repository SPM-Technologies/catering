# Maven Installation Guide for Windows

## Quick Install Steps

### Option 1: Using Chocolatey (Easiest - Recommended)

1. **Install Chocolatey** (if not installed):
   - Open PowerShell as Administrator
   - Run:
   ```powershell
   Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   ```

2. **Install Maven**:
   ```powershell
   choco install maven -y
   ```

3. **Verify Installation**:
   ```bash
   mvn --version
   ```

---

### Option 2: Manual Installation

#### Step 1: Download Maven

1. Go to: https://maven.apache.org/download.cgi
2. Download: **apache-maven-3.9.6-bin.zip** (or latest version)
3. Extract to: `C:\Program Files\Apache\maven`

#### Step 2: Set Environment Variables

1. **Open Environment Variables**:
   - Press `Win + R`
   - Type: `sysdm.cpl`
   - Click "Environment Variables"

2. **Add MAVEN_HOME**:
   - Under "System variables", click "New"
   - Variable name: `MAVEN_HOME`
   - Variable value: `C:\Program Files\Apache\maven`
   - Click OK

3. **Add to PATH**:
   - Under "System variables", find "Path"
   - Click "Edit"
   - Click "New"
   - Add: `%MAVEN_HOME%\bin`
   - Click OK on all dialogs

4. **Verify Installation**:
   - Open NEW Command Prompt (important!)
   - Run:
   ```bash
   mvn --version
   ```

Expected output:
```
Apache Maven 3.9.6
Maven home: C:\Program Files\Apache\maven
Java version: 21.x.x
```

---

### Option 3: Using Winget (Windows 11)

```bash
winget install Apache.Maven
```

---

## Verify Java Installation

Maven requires Java. Check if Java is installed:

```bash
java -version
```

If not installed:

### Install Java 21:

**Using Chocolatey**:
```bash
choco install openjdk21 -y
```

**Manual**:
1. Download from: https://adoptium.net/
2. Install JDK 21
3. Set JAVA_HOME environment variable

---

## After Maven Installation

Once Maven is installed, navigate to your project and run:

```bash
cd D:\Projects\GIT_Projects\catering
mvn clean package
mvn spring-boot:run
```

---

## Troubleshooting

### Problem: "mvn: command not found"
**Solution**: 
- Close and reopen terminal/command prompt
- Verify PATH includes Maven bin directory
- Run: `echo %PATH%` (should show Maven path)

### Problem: "JAVA_HOME not set"
**Solution**:
- Set JAVA_HOME to JDK installation directory
- Example: `C:\Program Files\Java\jdk-21`
- Add to PATH: `%JAVA_HOME%\bin`

### Problem: Maven runs but build fails
**Solution**:
- Check Java version: `java -version` (should be 21)
- Update Maven: `choco upgrade maven` or download latest
- Clear Maven cache: `mvn clean`

---

## Quick Test

After installation, test with:

```bash
mvn --version
java -version
```

Both should show version numbers.

---

## Next Steps

1. ✅ Install Maven (choose option above)
2. ✅ Verify: `mvn --version`
3. ✅ Build project: `mvn clean package`
4. ✅ Run application: `mvn spring-boot:run`
5. ✅ Access: http://localhost:8080/

---

**Need Help?** Check COMPLETE_DOCUMENTATION.md for more troubleshooting.
