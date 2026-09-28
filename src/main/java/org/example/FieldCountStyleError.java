package org.example;

public class FieldCountStyleError implements StyleError {
    private final int actualCount;
    private final int allowedCount;

    public FieldCountStyleError(int actualCount, int allowedCount) {
        this.actualCount = actualCount;
        this.allowedCount = allowedCount;
    }

    @Override
    public String format() {
        return "Class has " +
                actualCount +
                "fields, which is more than the allowed count (" +
                allowedCount +
                ")";
    }
}
