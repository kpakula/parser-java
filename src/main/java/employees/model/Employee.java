package employees.model;

import employees.adapter.EmployeeJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

import java.math.BigDecimal;

@JsonAdapter(EmployeeJsonAdapter.class)
public class Employee {
    private long id;
    private String name;
    private String surname;
    private String job;
    private BigDecimal salary;

    public Employee(long id, String name, String surname, String job, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.salary = salary;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

