package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Path.of(args[0]);
        Class cls = new JavaClass(path);
        List<StyleError> errors = ClassStyleChecker.check(cls);
        ClassStyleChecker.print(errors, System.out);
    }
}