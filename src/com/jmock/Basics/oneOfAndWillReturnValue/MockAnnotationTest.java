package com.jmock.Basics.oneOfAndWillReturnValue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

interface EmployeeSerive{
    String getDetailsOfEmployee(String dep,String id);
}

class Department{

    String dep;
    EmployeeSerive empservice;

    public Department(String dep, EmployeeSerive empservice) {
        this.dep = dep;
        this.empservice = empservice;
    }
    public String getEmployeeDetails(String id){
       return empservice.getDetailsOfEmployee(dep,id);
    }
}

public class MockAnnotationTest  {

    Mockery mockery ;
    EmployeeSerive empService;

    @Before
    public void setup(){
        mockery=new Mockery();
        empService=mockery.mock(EmployeeSerive.class);

    }
    @Test
    public void testEmployeeApi_1(){


        String dep="comp";
        String id="123";
        String empDetails="monu lumar,19,patna";

        mockery.checking(new Expectations(){{
            oneOf(empService).getDetailsOfEmployee(dep,id);
            will(returnValue(empDetails));
        }});
        Department dept=new Department(dep,empService);
        String details=dept.getEmployeeDetails(id);


        Assert.assertEquals(details,empDetails);
        mockery.assertIsSatisfied();

    }

}

class MockTestRunner1{
    public static void main(String[] args) {

        Result res = JUnitCore.runClasses(MockAnnotationTest.class);

        System.out.println(res.getRunCount());
        System.out.println(res.wasSuccessful());

    }
}