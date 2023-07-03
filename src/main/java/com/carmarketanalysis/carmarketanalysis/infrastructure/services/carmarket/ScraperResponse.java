package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket;

import java.util.List;

public class ScraperResponse {
    private final int total;
    private final List<CarItem> items;
    private final boolean nextPage;

    public ScraperResponse(int total, List<CarItem> items, boolean nextPage) {
        this.total = total;
        this.items = items;
        this.nextPage = nextPage;
    }

    public int getTotal() {
        return total;
    }

    public List<CarItem> getItems() {
        return items;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    @Override
    public String toString() {
        return "ScraperResponse{" +
                "total=" + total +
                ", items=" + items +
                ", nextPage=" + nextPage +
                '}';
    }
}
