package com.junit.parameterizedtesting;

import com.junit.annotation.ExceptionHandlingInTestAnnotation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Calculator{
    public boolean isEven(int num){
        return (num%2==0)?true:false;
    }
}
@RunWith(Parameterized.class)
public class CalculatorParameterizedTest{

    int num;
    boolean expectedResult;
    Calculator calc;
    @Before
    public void setup(){
        calc=new Calculator();
    }

    public CalculatorParameterizedTest(int num, boolean expectedResult) {
        this.num = num;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static List parameterForCalculator(){
        return  Arrays.asList(new Object[][]{ {4,true},{1,false},{19,false}});

    }
    @Test
    public void testMethod(){

        System.out.println("testMethod executed for num :"+num);
        Assert.assertEquals(expectedResult,calc.isEven(num));


    }
    @Test
    public void testMethod2(){

        System.out.println("testMethod2 executed for num :"+num);
        Assert.assertEquals(expectedResult,calc.isEven(num));


    }
}

 class ParameterizedTestingTestRunner {
    public static void main(String[] args) {
        Result results = JUnitCore.runClasses(CalculatorParameterizedTest.class);

        for (Failure fail : results.getFailures()) {
            System.out.println(fail);
        }
        System.out.println(results.getRunCount());
        System.out.println(results.wasSuccessful());
    }
}
