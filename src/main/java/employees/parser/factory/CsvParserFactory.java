package employees.parser.factory;

import employees.parser.ParserCsvStrategy;
import employees.parser.ParserStrategy;

public class CsvParserFactory implements ParserFactory {
    @Override
    public ParserStrategy makeParser() {
        return new ParserCsvStrategy();
    }
}
