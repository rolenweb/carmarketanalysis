package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

public class Odometer {
    private final int value;

    public Odometer(int value) {
        assertValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void assertValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be greater or equal zero");
        }
    }

    @Override
    public String toString() {
        return "Odometer{" +
                "value=" + value +
                '}';
    }
}
