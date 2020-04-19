package employees.parser.factory;

import employees.parser.ParserStrategy;

public interface ParserFactory {
    ParserStrategy makeParser();
}
