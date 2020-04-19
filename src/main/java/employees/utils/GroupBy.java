package employees.utils;


import employees.model.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {
    public static Map<String, BigDecimal> groupByJob(List<Employee> employees) {
        return employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getJob,
                                Collectors.reducing(BigDecimal.ZERO, Employee::getSalary, BigDecimal::add)
                        ));
    }
}
