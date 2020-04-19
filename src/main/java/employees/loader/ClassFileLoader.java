package employees.loader;

import java.io.File;
import java.util.Objects;

public class ClassFileLoader {
    public static File loadFile(String filename) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        return new File((Objects.requireNonNull(classLoader.getResource(filename))).getFile());
    }
}
