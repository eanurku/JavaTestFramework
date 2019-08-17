1.Junit setup 

download junit,hamcrest and add it to classpath .

*junit-4.12.jar

*hamcrest-core-1.3.jar

2.  compile/run test cases from command line 

-compile:

linux:

javac -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar CalculatorTest.java

window:

javac -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar CalculatorTest.java

-Run :

linux:

java -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest

windows:

java -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest



