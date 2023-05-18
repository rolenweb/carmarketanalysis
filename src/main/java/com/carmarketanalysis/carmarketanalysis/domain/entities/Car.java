package com.carmarketanalysis.carmarketanalysis.domain.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("cars")
public class Car {
    @Id
    private final  Long id;

    public Car(Long id) {
        this.id = id;
    }
}
