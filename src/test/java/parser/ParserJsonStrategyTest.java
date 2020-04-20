package parser;

import employees.model.Employee;
import employees.parser.ParserStrategy;
import employees.parser.factory.ParserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ParserJsonStrategyTest {
    @Test
    public void shouldBeEmpty() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy jsonParser = factory.getParser("notexist.json");
        List<Employee> employeeList = jsonParser.parse();

        Assertions.assertEquals(0, employeeList.size());
    }

    @Test
    public void shouldBeOnlyOneRow() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy jsonParser = factory.getParser("oneRow.json");
        List<Employee> employeeList = jsonParser.parse();

        Assertions.assertEquals(1, employeeList.size());
    }


    @Test
    public void shouldBeTwoRow() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy jsonParser = factory.getParser("twoRows.json");
        List<Employee> employeeList = jsonParser.parse();

        Assertions.assertEquals(2, employeeList.size());
    }

    @Test
    public void shouldBeSecondElementWithJanitorAsJob() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.json");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals("Janitor", employeeList.get(1).getJob());
    }

    @Test
    public void shouldNotBeSecondElementWithJanitorAsJob() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.json");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertNotEquals("NotJanitor", employeeList.get(1).getJob());
    }

    @Test
    public void shouldBeSalaryWithDot() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.json");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals(new BigDecimal("3540.20"), employeeList.get(0).getSalary());
    }

    @Test
    public void shouldBeFistElementWithNameOscar() {
        ParserFactory factory = new ParserFactory();
        ParserStrategy csvParser = factory.getParser("twoRows.json");

        List<Employee> employeeList = csvParser.parse();

        Assertions.assertEquals("Mark", employeeList.get(0).getName());
    }
}
