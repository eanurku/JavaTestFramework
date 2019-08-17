package com.junit.TestSuite;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


public class TestSuiteRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(AllClassTestSuite.class);

        System.out.println(result.getRunCount());
        System.out.println(result.wasSuccessful());

    }
}

//To DO
 class TestSuiteRunner2 {

    public static void main(String[] args) {

        TestSuite testsuite=new TestSuite(TestJunit1.class);
        TestResult testResults = new TestResult();
        testsuite.run(testResults);

        System.out.println(testResults.wasSuccessful());

    }
}