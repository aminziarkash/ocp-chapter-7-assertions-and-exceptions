package com.az.dev.ocp;

public class Employee implements AutoCloseable {
    
    String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("close() method from 'Employee' class");
    }

    public static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setName("Amin Ziarkash");
        return employee;
    }
}
