package com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.ru.auto;

import com.carmarketanalysis.carmarketanalysis.domain.valueobjects.Name;
import com.carmarketanalysis.carmarketanalysis.infrastructure.services.carmarket.CarItem;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Primary
public class AutoSeleniumScraperImpl implements AutoScraper{
    private static final Logger logger = LoggerFactory.getLogger(AutoSeleniumScraperImpl.class);
    private final WebDriver webDriver;

    @Autowired
    public AutoSeleniumScraperImpl(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public List<CarItem> scrape(URI uri) {
        List<CarItem> cars = new ArrayList<>();
        var url = uri.toString();
        logger.info("Scrape url: {}", url);
        webDriver.get(url);
        var confirmButtons = webDriver.findElements(By.id("confirm-button"));
        if (!confirmButtons.isEmpty()) {
            logger.info("Click confirm button");
            confirmButtons.get(0).click();
        }
        collectItems(cars);
        webDriver.quit();
        return cars;
    }

    private void collectItems(List<CarItem> carItems) {
        var listItems = webDriver.findElements(By.className("ListingItem"));
        if (listItems.isEmpty()) {
            logger.error("List of items is empty");
            return;
        }
        for (WebElement item: listItems) {
            try {
                var titleElement = item.findElement(By.className("ListingItemTitle__link"));
                var name = new Name(titleElement.getText());
                var source = new URL(titleElement.getAttribute("href"));
                logger.info("Title: {}", name);
                logger.info("Url: {}", source);
                var techDetails = item.findElements(By.className("ListingItemTechSummaryDesktop__cell"));
                List<String> engineDetails = Arrays.stream(techDetails.get(0).getText().split("/")).toList();
                String engineCapacity = engineDetails.get(0);
                String enginePower = engineDetails.get(1);
                String engineType = engineDetails.get(2);
                String transmission = techDetails.get(1).getText();
                for (WebElement techDetail : techDetails) {
                    logger.info("Tech detail: {}", techDetail.getText());
                }
                var priceBlock = item.findElement(By.className("ListingItem__priceBlock"));
                var price = priceBlock.findElement(By.className("Link"));
                logger.info("Price: {}", price.getText());

                var yearBlock = item.findElement(By.className("ListingItem__yearBlock"));
                var year = yearBlock.findElement(By.className("ListingItem__year"));
                logger.info("Year: {}", year.getText());

                var kmAgeBlock = item.findElement(By.className("ListingItem__kmAgeAndActionsBlock"));
                var kmAge = kmAgeBlock.findElement(By.className("ListingItem__kmAge"));
                logger.info("KmAge: {}", kmAge.getText());
                var carItem = new CarItem(
                        titleElement.getText(),
                        titleElement.getAttribute("href"),
                        price.getText(),
                        kmAge.getText(),
                        year.getText(),
                        engineCapacity,
                        enginePower,
                        engineType,
                        transmission
                );
                carItems.add(carItem);
            } catch (NoSuchElementException | MalformedURLException exception) {
                logger.error(exception.toString());
            }
        }
    }
}
