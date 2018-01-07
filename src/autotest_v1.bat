cls
copy /Y "I:\2017project\³ÂÆäÀÖ\MiniJava\MiniJava\MiniJava.g4" .
del Mini*.java
call antlr4.bat MiniJava.g4
javac -cp .\antlr-4.7.1-complete.jar *.java
call grun.bat error_test%1