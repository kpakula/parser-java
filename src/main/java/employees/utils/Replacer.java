package employees.utils;

import employees.model.Sign;

public class Replacer {
    public static String replaceCommaByDot(String current) {
        return current.replaceAll(Sign.COMMA, Sign.DOT);
    }

    public static String replaceUnwantedSigns(String lines) {
        return lines
                .replaceAll(Sign.WHITESPACES, Sign.EMPTY)
                .replaceAll(Sign.QUOTATION_MARK, Sign.EMPTY)
                .replaceAll(Sign.COMMA, Sign.DOT);
    }

    public static String replaceQuotationMarkByEmpty(String line) {
        return line.replaceAll(Sign.QUOTATION_MARK, Sign.EMPTY);
    }

    public static String replaceWhiteSpacesByEmpty(String line) {
        return line.replaceAll(Sign.WHITESPACES, Sign.EMPTY);
    }
}
