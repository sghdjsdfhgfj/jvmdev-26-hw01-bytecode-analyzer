package org.example;

import java.lang.classfile.FieldModel;

public class JavaField implements Field {
    private final FieldModel fieldModel;

    public JavaField(FieldModel fieldModel) {
        this.fieldModel = fieldModel;
    }

    @Override
    public String getName() {
        return fieldModel.fieldName().stringValue();
    }
}
