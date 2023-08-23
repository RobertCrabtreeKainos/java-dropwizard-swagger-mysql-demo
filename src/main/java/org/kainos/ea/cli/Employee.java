package org.kainos.ea.cli;

public class Employee implements IPayable, IPermenant{
    public Employee(int employeeId, String name, double salary)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }
    public double calcPay() {
        return getSalary() / 12;
    }
    public double getSalary() {
        return salary;
    }
    public double calcBonus(){
        return salary * 0.1;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    private int employeeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private double salary;
}
