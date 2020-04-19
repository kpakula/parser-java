package employees.parser;

import employees.model.Employee;
import employees.wrapper.EmployeesWrapper;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ParserJsonStrategy implements ParserStrategy {
    @Override
    public List<Employee> parse(String filename) {

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
