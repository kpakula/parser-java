package employees;

import employees.model.Employee;
import employees.parser.ParserStrategy;
import employees.parser.factory.ParserFactory;
import employees.utils.GroupBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.status.StatusLogger;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StatusLogger.getLogger().setLevel(Level.OFF);

        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy csvStrategy = parserFactory.getParser("employees.csv");
        ParserStrategy jsonStrategy = parserFactory.getParser("employees.json");


        //Csv
        List<Employee> employeesCsv = csvStrategy.parse();
        Map<String, BigDecimal> csvResult = GroupBy.groupByJob(employeesCsv);


        // Json
        List<Employee> employeesJson = jsonStrategy.parse();
        Map<String, BigDecimal> jsonResult = GroupBy.groupByJob(employeesJson);


        System.out.println("-CSV-");
        System.out.println(csvResult);
        System.out.println();
        System.out.println("-JSON-");
        System.out.println(jsonResult);

    }
}
