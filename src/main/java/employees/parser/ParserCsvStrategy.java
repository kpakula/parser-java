package employees.parser;

import employees.model.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ParserCsvStrategy implements ParserStrategy{
    @Override
    public List<Employee> parse(String filename) {

        List<Employee> employees = new ArrayList<>();

        try {

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
