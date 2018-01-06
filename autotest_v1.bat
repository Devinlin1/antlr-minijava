del Mini*.java
copy /Y "I:\2017project\³ÂÆäÀÖ\MiniJava\MiniJava\MiniJava.g4" .
call antlr4.bat MiniJava.g4
javac -cp .\antlr-4.7.1-complete.jar *.java
java -cp .\antlr-4.7.1-complete.jar;%CLASSPATH% org.antlr.v4.gui.TestRig MiniJava prog -gui TestCase/test1.java
