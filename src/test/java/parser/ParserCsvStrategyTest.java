package parser;

import employees.model.Employee;
import employees.parser.ParserStrategy;
import employees.parser.factory.ParserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ParserCsvStrategyTest {

    @Test
    public void shouldBeEmpty() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("notexist.csv");
        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals(0, employeeList.size());
    }

    @Test
    public void shouldBeOnlyOneRow() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("oneRow.csv");
        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals(1, employeeList.size());
    }

    @Test
    public void shouldBeTwoRow() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.csv");
        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldBeFirstElementWithTeacherAsJob() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.csv");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals("Teacher", employeeList.get(0).getJob());
    }

    @Test
    public void shouldNotBeFirstElementWithTeacherAsJob() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.csv");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertNotEquals("NotTeacher", employeeList.get(0).getJob());
    }

    @Test
    public void shouldBeSalaryWithDot() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.csv");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals(new BigDecimal("3540.20"), employeeList.get(0).getSalary());
    }



}
