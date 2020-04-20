package parser.factory;

import employees.parser.ParserCsvStrategy;
import employees.parser.ParserJsonStrategy;
import employees.parser.ParserStrategy;
import employees.parser.factory.ParserFactory;
import employees.parser.factory.exceptions.UnknownFileTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserFactoryTest {


    @Test
    void shouldBeCsvParser() {
        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy strategy = parserFactory.getParser("git.csv");


        Assertions.assertTrue(strategy instanceof ParserCsvStrategy);
    }

    @Test
    void shouldNotBeCsvParser() {
        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy strategy = parserFactory.getParser("git.json");

        Assertions.assertFalse(strategy instanceof ParserCsvStrategy);
    }

    @Test
    void shouldBeJsonParser() {
        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy strategy = parserFactory.getParser("git.json");

        Assertions.assertTrue(strategy instanceof ParserJsonStrategy);
    }

    @Test
    void shouldNotBeJsonParser() {
        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy strategy = parserFactory.getParser("git.csv");

        Assertions.assertFalse(strategy instanceof ParserJsonStrategy);
    }


    @Test
    void shouldBeThrowException() {
        Assertions.assertThrows(UnknownFileTypeException.class, () -> {
            ParserFactory parserFactory = new ParserFactory();
            ParserStrategy strategy = parserFactory.getParser("x.xx");
        });
    }

    @Test
    void shouldBeNotNullParser() {
        ParserFactory parserFactory = new ParserFactory();
        ParserStrategy strategy = parserFactory.getParser("git.json");

        Assertions.assertNotNull(strategy);
    }

}
