del *.java
call antlr4.bat MiniJava.g4
javac -cp .\antlr-4.7.1-complete.jar *.java
call grun.bat %1