package employees;

import employees.controller.Controller;
import employees.model.Employee;
import employees.parser.factory.CsvParserFactory;
import employees.parser.factory.JsonParserFactory;
import employees.utils.GroupBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        JsonParserFactory jsonParserFactory = new JsonParserFactory();
        CsvParserFactory csvParserFactory = new CsvParserFactory();

        // Json
        Controller context = new Controller(jsonParserFactory.makeParser());
        List<Employee> employeesJson = context.parse("employees.json");
        Map<String, BigDecimal> jsonResult = GroupBy.groupByJob(employeesJson);

        System.out.println(jsonResult);



//         Csv
        context = new Controller(csvParserFactory.makeParser());
        List<Employee> employeesCsv = context.parse("employees.csv");
        Map<String, BigDecimal> csvResult = GroupBy.groupByJob(employeesCsv);


        System.out.println(csvResult);

    }
}
