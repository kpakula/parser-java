package employees.parser;

import employees.model.Employee;

import java.util.List;

public interface ParserStrategy {
    List<Employee> parse();
}
