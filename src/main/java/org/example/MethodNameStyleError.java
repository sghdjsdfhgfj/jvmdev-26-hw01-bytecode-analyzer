package org.example;

public class MethodNameStyleError implements StyleError {
    private final String methodName;

    public MethodNameStyleError(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String format() {
        return "Method name " + methodName + " is not in camel-case";
    }
}
