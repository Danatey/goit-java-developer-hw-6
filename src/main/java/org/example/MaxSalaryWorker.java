package org.example;

public class MaxSalaryWorker {

    private final int salary;
    private final String name;

    public MaxSalaryWorker(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public long getSalary() { return salary; }

    public String getName() { return name; }
}
