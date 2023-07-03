package com.carmarketanalysis.carmarketanalysis.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class WebClientConfiguration {

    @Bean
    public ExchangeStrategies exchangeStrategies () {
        final int size = 16 * 1024 * 1024;
        return ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @Bean
    public WebDriver webDriver() throws MalformedURLException {
        /*System.setProperty("webdriver.chrome.whitelistedIps", "");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");*/

        var options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        return new RemoteWebDriver(new URL("http://localhost:4441/"), options);
    }
}
