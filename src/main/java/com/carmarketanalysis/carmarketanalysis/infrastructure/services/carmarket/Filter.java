package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket;

import com.carmarketanalysis.carmarketanalysis.domain.entities.Brand;
import com.carmarketanalysis.carmarketanalysis.domain.entities.Model;
import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Year;

public class Filter {
    private static final Logger logger = LoggerFactory.getLogger(Filter.class);
    private int page;
    private final Brand brand;
    private final Model model;
    private Transmission transmission;
    private EngineType engineType;
    private EngineCapacity engineCapacityFrom;
    private EngineCapacity engineCapacityTo;
    private Power powerFrom;
    private Power powerTo;
    private Year yearFrom;
    private Year yearTo;
    private Odometer odometerFrom;
    private Odometer odometerTo;

    public Filter(int page, Brand brand, Model model) {
        this.page = page;
        this.brand = brand;
        this.model = model;
    }

    public void nextPage() {
        logger.info("Increase page");
        page++;
    }

    public int getPage() {
        return page;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public EngineCapacity getEngineCapacityFrom() {
        return engineCapacityFrom;
    }

    public EngineCapacity getEngineCapacityTo() {
        return engineCapacityTo;
    }

    public Power getPowerFrom() {
        return powerFrom;
    }

    public Power getPowerTo() {
        return powerTo;
    }

    public Year getYearFrom() {
        return yearFrom;
    }

    public Year getYearTo() {
        return yearTo;
    }

    public Odometer getOdometerFrom() {
        return odometerFrom;
    }

    public Odometer getOdometerTo() {
        return odometerTo;
    }

    public Filter setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Filter setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public Filter setEngineCapacityFrom(EngineCapacity engineCapacityFrom) {
        this.engineCapacityFrom = engineCapacityFrom;
        return this;
    }

    public Filter setEngineCapacityTo(EngineCapacity engineCapacityTo) {
        this.engineCapacityTo = engineCapacityTo;
        return this;
    }

    public Filter setPowerFrom(Power powerFrom) {
        this.powerFrom = powerFrom;
        return this;
    }

    public Filter setPowerTo(Power powerTo) {
        this.powerTo = powerTo;
        return this;
    }

    public Filter setYearFrom(Year yearFrom) {
        this.yearFrom = yearFrom;
        return this;
    }

    public Filter setYearTo(Year yearTo) {
        this.yearTo = yearTo;
        return this;
    }

    public Filter setOdometerFrom(Odometer odometerFrom) {
        this.odometerFrom = odometerFrom;
        return this;
    }

    public Filter setOdometerTo(Odometer odometerTo) {
        this.odometerTo = odometerTo;
        return this;
    }

    public boolean isOneYear() {
        if (yearTo == null || yearFrom == null) {
            return false;
        }
        return yearTo.equals(yearFrom);
    }

    @Override
    public String toString() {
        return "Filter{" +
                "page=" + page +
                ", brand=" + brand +
                ", model=" + model +
                ", transmission=" + transmission +
                ", engineType=" + engineType +
                ", engineCapacityFrom=" + engineCapacityFrom +
                ", engineCapacityTo=" + engineCapacityTo +
                ", powerFrom=" + powerFrom +
                ", powerTo=" + powerTo +
                ", yearFrom=" + yearFrom +
                ", yearTo=" + yearTo +
                ", odometerFrom=" + odometerFrom +
                ", odometerTo=" + odometerTo +
                '}';
    }
}
