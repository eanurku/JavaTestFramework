package com.junit.annotation;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static junit.framework.TestCase.fail;

public class IgnoreAnnotationInJunit {
    @Ignore
    @Test
    public void testToBeIgnored(){
        Assert.assertEquals("abc","xyz");
    }
    @Test
    public void test1(){
        System.out.println("inside test1");
    }

}

class IgnoreAnnotationInJunitTestRunner{
    public static void main(String[] args) {
        Result results = JUnitCore.runClasses(IgnoreAnnotationInJunit.class);

        System.out.println(results.getRunCount());
        System.out.println(results.wasSuccessful());

    }
}
