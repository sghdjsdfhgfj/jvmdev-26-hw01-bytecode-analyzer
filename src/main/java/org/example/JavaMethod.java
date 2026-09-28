package org.example;

import java.lang.classfile.MethodModel;

public class JavaMethod implements Method {
    private final MethodModel methodModel;

    public JavaMethod(MethodModel methodModel) {
        this.methodModel = methodModel;
    }

    @Override
    public String getName() {
        return methodModel.methodName().stringValue().split("\\$")[0];
    }
}
