package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

public enum EngineType {
    PETROL("petrol"),
    DIESEL("Diesel"),
    HYBRID("Hybrid"),
    ELECTRIC("Electric"),
    GAS("Gas");
    private final String value;

    EngineType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
