package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Car;

import java.util.List;

public interface CarMarket {
    List<Car> findByFilter(Filter filter);
}
