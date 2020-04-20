package employees.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Objects;

public class ClassFileLoader {
    public static File loadFile(String filename) throws FileNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(filename);

        if (url == null) {
            throw new FileNotFoundException();
        }

        return new File((Objects.requireNonNull(classLoader.getResource(filename))).getFile());
    }
}
