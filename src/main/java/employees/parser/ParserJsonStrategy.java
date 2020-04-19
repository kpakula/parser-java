package employees.parser;

import employees.model.Employee;
import employees.wrapper.EmployeesWrapper;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ParserJsonStrategy implements ParserStrategy {

    private String filename;

    public ParserJsonStrategy(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Employee> parse() {

        EmployeesWrapper employeesWrapper = new EmployeesWrapper();

        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            employeesWrapper = gson.fromJson(reader, EmployeesWrapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeesWrapper.getEmployees();
    }
}
