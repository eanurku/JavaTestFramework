package com.junit.annotation;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ExceptionHandlingInTestAnnotation {

    @Test(expected = NullPointerException.class)
    public void testThrowsException() {

        System.out.println("inside  testThrowsException");
        throw new NullPointerException();
    }

    @Test
    public void test1() {

        System.out.println("inside test1");
    }
}


class ExceptionHandlingInTestAnnotationTestRunner {
    public static void main(String[] args) {
        Result results = JUnitCore.runClasses(ExceptionHandlingInTestAnnotation.class);

        for (Failure fail : results.getFailures()) {
            System.out.println(fail);
        }
        System.out.println(results.getRunCount());
        System.out.println(results.wasSuccessful());
    }
}