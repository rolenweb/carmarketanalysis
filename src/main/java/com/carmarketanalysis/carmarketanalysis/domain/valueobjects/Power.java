package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

public class Power {
    private final int value;

    public Power(int value) {
        assertValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void assertValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Power must be greater than 0");
        }
        if (value > 1000) {
            throw new IllegalArgumentException("Power must be less then 1000");
        }
    }
}
