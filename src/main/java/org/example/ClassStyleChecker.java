package org.example;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ClassStyleChecker {
    public static List<StyleError> check(Class cls) {
        int maxFields = 10;

        ArrayList<StyleError> errors = new ArrayList<>();
        int fields = cls.getFields().size();
        if (fields > maxFields) {
            errors.add(new FieldCountStyleError(fields, maxFields));
        }
        cls.getMethods().forEach(method -> {
            String methodName = method.getName();
            if (!isCamelCase(methodName)) {
                errors.add(new MethodNameStyleError(methodName));
            }
        });
        return errors;
    }

    public static void print(List<StyleError> errors, PrintStream out) {
        out.print("Style check results: ");
        if (!errors.isEmpty()) {
            out.println("FAIL");
            out.println("Errors:");
            for (StyleError error : errors) {
                out.println(error.format());
            }
        } else {
            out.println("PASS");
        }
    }

    private static boolean isCamelCase(String str) {
        return str.matches("^[a-z][a-z0-9]*(([A-Z][a-z0-9]+)*[A-Z]?|([a-z0-9]+[A-Z])*|[A-Z])$");
    }
}
