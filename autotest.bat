del *.java
copy /Y MiniJava_v%1.g4 MiniJava.g4
call antlr4.bat MiniJava.g4
javac -cp .\antlr-4.7.1-complete.jar *.java
call grun.bat binarysearch