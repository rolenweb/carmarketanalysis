package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket;

import java.net.URL;

public class CarItem {
    private final String title;
    private final String url;
    private final String price;
    private final String kmAge;
    private final String year;
    private final String engineCapacity;
    private final String power;
    private final String engineType;
    private final String transmission;

    public CarItem(String title, String url, String price, String kmAge, String year, String engineCapacity, String power, String engineType, String transmission) {
        this.title = title;
        this.url = url;
        this.price = price;
        this.kmAge = kmAge;
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.power = power;
        this.engineType = engineType;
        this.transmission = transmission;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }

    public String getKmAge() {
        return kmAge;
    }

    public String getYear() {
        return year;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public String getPower() {
        return power;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "CarItem{" +
                "title='" + title + '\'' +
                ", url=" + url +
                ", price='" + price + '\'' +
                ", kmAge='" + kmAge + '\'' +
                ", year='" + year + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", power='" + power + '\'' +
                ", engineType='" + engineType + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
