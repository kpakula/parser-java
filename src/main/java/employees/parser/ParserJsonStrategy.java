package employees.parser;

import com.google.gson.Gson;
import employees.model.Employee;
import employees.utils.ClassFileLoader;
import employees.wrapper.EmployeesWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ParserJsonStrategy implements ParserStrategy {

    private static final Logger logger = LoggerFactory.getLogger(ParserJsonStrategy.class);

    private final String filename;

    public ParserJsonStrategy(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Employee> parse() {

        EmployeesWrapper employeesWrapper = new EmployeesWrapper();

        try (FileReader reader = new FileReader(ClassFileLoader.loadFile(filename))) {
            Gson gson = new Gson();
            employeesWrapper = gson.fromJson(reader, EmployeesWrapper.class);
        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("File Not Found Exception " + fileNotFoundException.getMessage());
        } catch (IOException ioException) {
            logger.error("IOException " + ioException.getMessage());
        }

        return employeesWrapper.getEmployees();
    }
}
