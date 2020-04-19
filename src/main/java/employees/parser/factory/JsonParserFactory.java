package employees.parser.factory;

import employees.parser.ParserJsonStrategy;
import employees.parser.ParserStrategy;

public class JsonParserFactory implements ParserFactory{
    @Override
    public ParserStrategy makeParser() {
        return new ParserJsonStrategy();
    }
}
