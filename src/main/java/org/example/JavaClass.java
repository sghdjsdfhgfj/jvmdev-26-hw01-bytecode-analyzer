package org.example;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.nio.file.Path;
import java.util.List;

public class JavaClass implements Class {
    private final ClassModel model;
    public JavaClass(Path path) throws IOException {
        model = ClassFile.of().parse(path);
    }

    @Override
    public List<Field> getFields() {
        return model.fields().stream()
                .<Field>map(JavaField::new)
                .toList();
    }

    @Override
    public List<Method> getMethods() {
        return model.methods().stream()
                .filter(method -> !method.methodName().stringValue().startsWith("<"))
                .<Method>map(JavaMethod::new)
                .toList();
    }
}
