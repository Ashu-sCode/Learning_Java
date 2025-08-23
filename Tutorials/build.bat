@echo off
REM ==============================
REM Build and Run Java Project
REM ==============================

REM Step 1: Clean old compiled classes
if exist bin rmdir /s /q bin

REM Step 2: Create bin folder
mkdir bin

REM Step 3: Compile all Java files inside basics package
javac -d bin basics\lesson1\*.java

REM Step 4: Run the Main class
echo.
echo Running program...
java -cp bin basics.lesson1.Main
