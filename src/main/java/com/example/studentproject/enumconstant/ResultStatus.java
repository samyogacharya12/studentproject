package com.example.studentproject.enumconstant;

import java.util.Arrays;
import java.util.List;

public enum ResultStatus {

    PASS("Pass"), Fail("Fail");

    private final String value;

    ResultStatus(String value) {
        this.value = value;
    }

    public static ResultStatus getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (ResultStatus v : values())
            if (value.equalsIgnoreCase(v.getValue()))
                return v;
        throw new IllegalArgumentException();
    }

    public static List<ResultStatus> getEnumList(ResultStatus... statuses) {
        return Arrays.asList(statuses);
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

}
