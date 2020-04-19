package employees.utils;

import employees.model.Sign;

public class Replacer {
    public static String replaceCommaByDot(String current) {
        return current.replaceAll(Sign.COMMA, Sign.DOT);
    }

    public static String[] replaceUnwantedSigns(String lines) {
        return lines
                .replaceAll(Sign.WHITESPACES, Sign.EMPTY)
                .replaceAll(Sign.QUOTATION_MARK, Sign.EMPTY)
                .replaceAll(Sign.COMMA, Sign.DOT)
                .split(Sign.SEMICOLON);
    }
}
