package com.carmarketanalysis.carmarketanalysis.domain.valueobjects;

public enum Transmission {
    AUTOMATIC("Automatic"),
    ROBOT("Robot"),
    VARIATOR("Variator"),

    MECHANIC("Mechanic");
    private final String value;

    Transmission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
