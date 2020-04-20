package employees.parser.factory.exceptions;

public class UnknownFileTypeException extends RuntimeException {
    public UnknownFileTypeException(String message) {
        super(String.format("File %s has unkown type ", message));
    }
}
