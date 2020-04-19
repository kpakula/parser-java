package employees;

import employees.model.Employee;
import employees.parser.ParserStrategy;
import employees.parser.factory.ParserFactory;
import employees.utils.GroupBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy csvStrategy = parserFactory.getParser("employees.csv");
        ParserStrategy jsonStrategy = parserFactory.getParser("employees.json");


        //Csv
        List<Employee> employeesCsv = csvStrategy.parse();
        Map<String, BigDecimal> csvResult = GroupBy.groupByJob(employeesCsv);


        // Json
        List<Employee> employeesJson = jsonStrategy.parse();
        Map<String, BigDecimal> jsonResult = GroupBy.groupByJob(employeesJson);


        System.out.println(csvResult);
        System.out.println(jsonResult);

    }
}
