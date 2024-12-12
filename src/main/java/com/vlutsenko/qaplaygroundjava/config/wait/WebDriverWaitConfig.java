package com.vlutsenko.qaplaygroundjava.config.wait;

import com.vlutsenko.qaplaygroundjava.config.annotations.LazyConfigurationPrototypeScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.time.Duration;


@LazyConfigurationPrototypeScope
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
}
