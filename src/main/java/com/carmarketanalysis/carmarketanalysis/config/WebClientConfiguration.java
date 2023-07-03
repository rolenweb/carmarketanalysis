package com.carmarketanalysis.carmarketanalysis.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class WebClientConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(WebClientConfiguration.class);

    /*@Bean
    public WebDriver webDriver() throws MalformedURLException {
        logger.info("Init web driver");
        var options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        return new RemoteWebDriver(new URL("http://localhost:4441/"), options);
    }*/
}
