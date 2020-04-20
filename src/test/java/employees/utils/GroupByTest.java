package employees.utils;

import employees.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupByTest {

    @Test
    public void shouldBeEmpty() {
        List<Employee> empty = new ArrayList<>();
        Map<String, BigDecimal> map = GroupBy.groupByJob(empty);

        Assertions.assertTrue(map.isEmpty());
    }

    @Test
    public void shouldNotBeEmpty() {
        List<Employee> notEmpty = new ArrayList<>();
        notEmpty.add(new Employee(1, "First", "Last", "Title", new BigDecimal("12.51")));
        Map<String, BigDecimal> map = GroupBy.groupByJob(notEmpty);

        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    public void shouldBeOneElement() {
        List<Employee> notEmpty = new ArrayList<>();
        notEmpty.add(new Employee(1, "First", "Last", "Title", new BigDecimal("12.51")));
        Map<String, BigDecimal> map = GroupBy.groupByJob(notEmpty);

        Assertions.assertEquals(1, map.size());
    }

    @Test
    public void shouldBeOneElementGrouped() {
        List<Employee> notEmpty = new ArrayList<>();
        notEmpty.add(new Employee(1, "First", "Last", "Title", new BigDecimal("12.51")));
        notEmpty.add(new Employee(2, "First", "Last", "Title", new BigDecimal("12.51")));

        Map<String, BigDecimal> map = GroupBy.groupByJob(notEmpty);

        Assertions.assertEquals(1, map.size());
    }

    @Test
    public void shouldBeTwoElementGrouped() {
        List<Employee> notEmpty = new ArrayList<>();
        notEmpty.add(new Employee(1, "First", "Last", "Title1", new BigDecimal("12.51")));
        notEmpty.add(new Employee(2, "First", "Last", "Title2", new BigDecimal("12.51")));

        Map<String, BigDecimal> map = GroupBy.groupByJob(notEmpty);

        Assertions.assertEquals(2, map.size());
    }

    @Test
    public void shouldBeTwoElementGroupedByTitle() {
        List<Employee> notEmpty = new ArrayList<>();
        notEmpty.add(new Employee(1, "First", "Last", "Title1", new BigDecimal("12.51")));
        notEmpty.add(new Employee(2, "First", "Last", "Title1", new BigDecimal("12.51")));
        notEmpty.add(new Employee(3, "First", "Last", "Title2", new BigDecimal("12.51")));
        notEmpty.add(new Employee(4, "First", "Last", "Title2", new BigDecimal("12.51")));

        Map<String, BigDecimal> map = GroupBy.groupByJob(notEmpty);

        Assertions.assertEquals(2, map.size());
    }

}
