package com.junit.annotation;


import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CommonAnnotationsInJunit{

    @BeforeClass
    public static void setupOnce(){
        System.out.println("inside setupOnce");
    }
    @AfterClass
    public static void tearUpOnce(){
        System.out.println("inside tearUpOnce");
    }
    @Before
    public void setupBeforeEverytest(){
        System.out.println("inside setupBeforeEverytest");
    }
    @After
    public void tearupAfterEverytest(){
        System.out.println("inside tearupAfterEverytest");
    }

    @Test
    public void testMethod_1(){
        System.out.println("inside test method 1");
    }

    @Test
    public void testMethod_2(){
        System.out.println("inside test method 2");
    }

}
 class AnnotationsDemo {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CommonAnnotationsInJunit.class);
        for(Failure res :result.getFailures()){
            System.out.println(res);
        }
        System.out.println(result.wasSuccessful());

    }
}
