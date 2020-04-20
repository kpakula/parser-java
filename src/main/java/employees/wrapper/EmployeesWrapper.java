package employees.wrapper;


import employees.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesWrapper {
    private List<Employee> employees;

    public EmployeesWrapper(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeesWrapper() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
