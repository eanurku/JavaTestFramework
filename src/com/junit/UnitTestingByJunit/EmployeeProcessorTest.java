package com.junit.UnitTestingByJunit;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

class Employee{
    String name;
    String level;
    int salary;

    public Employee(String name, String level, int salary) {
        this.name = name;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
class EmployeeProcessor{

    Employee emp;

    public EmployeeProcessor(Employee emp) {
        this.emp = emp;
    }

    int calculateSalaryBonus(){
        if(emp.getLevel().equals("1")){
            return emp.getSalary()/100;
        }
        else
            return (emp.getSalary()/100)+100;
    }
}

 public class EmployeeProcessorTest{
    Employee emp;
    EmployeeProcessor empProc;

    @Before
    public void setup(){
         emp=new Employee("emp","1",100);
         empProc=new EmployeeProcessor(emp);

    }
    @Test
    public void testslaryForlevel1(){

        Assert.assertEquals(1,empProc.calculateSalaryBonus());

    }


}
 class TestDemo {

     public static void main(String[] args) {
         Result results = JUnitCore.runClasses(EmployeeProcessorTest.class);
         System.out.println(results.wasSuccessful());
     }
}
