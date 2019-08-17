package com.junit.annotation;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TimeoutParameterInTestAnnotation {


    @Test(timeout = 1)
    public void testMethodWithTimeout() throws InterruptedException {

        System.out.println("inside test method with timeout");
        Thread.sleep(10000);
    }
}

class TimeoutParameterInTestAnnotationTestRunner{
    public static void main(String[] args) {
        Result results = JUnitCore.runClasses(TimeoutParameterInTestAnnotation.class);

        for(Failure fail:results.getFailures()){
            System.out.println(fail);
        }
        System.out.println(results.getRunCount());
        System.out.println(results.wasSuccessful());

    }
}