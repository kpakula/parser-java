package employees.parser.factory;

import employees.parser.ParserCsvStrategy;
import employees.parser.ParserJsonStrategy;
import employees.parser.ParserStrategy;
import employees.parser.factory.exceptions.UnknownFileTypeException;

public class ParserFactory {
    public ParserStrategy getParser(String filename) {
        if (filename == null) {
            throw new UnknownFileTypeException(null);
        }

        if (filename.endsWith(".csv")) {
            return new ParserCsvStrategy(filename);
        } else if (filename.endsWith(".json")) {
            return new ParserJsonStrategy(filename);
        }


        throw new UnknownFileTypeException(filename);

    }
}
