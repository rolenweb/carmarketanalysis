package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

import org.springframework.util.Assert;

public class Name {
    private final String value;

    public Name(String value) {
        Assert.hasLength(value, "Name must not be empty");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
