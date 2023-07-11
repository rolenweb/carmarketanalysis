package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

public class EngineCapacity {
    private final float value;

    public EngineCapacity(float value) {
        assertValue(value);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    private void assertValue(float value) {
        if (value < 0.2) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0.2");
        }
        if (value > 10) {
            throw new IllegalArgumentException("Engine capacity must be less than 10");
        }
    }

    @Override
    public String toString() {
        return "EngineCapacity{" +
                "value=" + value +
                '}';
    }
}
