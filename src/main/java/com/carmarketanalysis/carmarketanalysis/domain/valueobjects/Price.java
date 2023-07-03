package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

import org.springframework.util.Assert;

public class Price {
    private final float value;

    public Price(float value) {
        assertValue(value);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    private void  assertValue(float value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be greater than 0");
        }
    }
}
