package employees.parser.factory;

import employees.parser.ParserCsvStrategy;
import employees.parser.ParserJsonStrategy;
import employees.parser.ParserStrategy;

public class ParserFactory {
    public ParserStrategy getParser(String filename) {
        if (filename == null) {
            return null;
        }

        if (filename.endsWith(".csv")) {
            return new ParserCsvStrategy(filename);
        } else if (filename.endsWith(".json")) {
            return new ParserJsonStrategy(filename);
        }

        return null;
    }
}
