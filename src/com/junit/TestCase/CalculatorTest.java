package com.junit.TestCase;

import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class CalculatorTest extends TestCase {

    public void testMethod_1(){

        System.out.println("inside test method 1");
    }
}

class testRunner{
    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(CalculatorTest.class);
        System.out.println(res.getRunCount());
        System.out.println(res.wasSuccessful());
    }
}