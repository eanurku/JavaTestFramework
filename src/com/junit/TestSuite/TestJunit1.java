package com.junit.TestSuite;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertEquals;

  public class TestJunit1 {

    @Test
    public void testMethod1(){
        assertEquals("value","value");
    }
}


