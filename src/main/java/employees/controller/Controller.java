package employees.controller;

import employees.model.Employee;
import employees.parser.ParserStrategy;

import java.util.List;

public class Controller {
    private ParserStrategy parserStrategy;

    public Controller(ParserStrategy parserStrategy) {
        this.parserStrategy = parserStrategy;
    }

    public List<Employee> parse(String filename) {
        return parserStrategy.parse(filename);
    }
}
