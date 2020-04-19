package employees.parser;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import employees.loader.ClassFileLoader;
import employees.model.Employee;
import employees.utils.Replacer;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParserCsvStrategy implements ParserStrategy{
    @Override
    public List<Employee> parse(String filename) {
        List<Employee> employees = new ArrayList<>();

        try (FileReader fileReader = new FileReader(ClassFileLoader.loadFile(filename))){

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();


            for (String[] row : allData) {

                long id = Long.parseLong(Replacer.replaceUnwantedSigns(row[0]));
                String name = Replacer.replaceUnwantedSigns(row[1]);
                String surname = Replacer.replaceUnwantedSigns(row[2]);
                String job = Replacer.replaceUnwantedSigns(row[3]);
                BigDecimal salary = new BigDecimal(Replacer.replaceUnwantedSigns((row[4])));

                Employee employee = new Employee(id, name, surname, job, salary);


                employees.add(employee);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }


        return employees;
    }
}
