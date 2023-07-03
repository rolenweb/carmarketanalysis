package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

public enum OdometerType {
    KM("km"), MILE("mile");
    private final String value;

    OdometerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
