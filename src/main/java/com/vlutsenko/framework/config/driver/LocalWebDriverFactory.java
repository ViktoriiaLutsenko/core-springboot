package com.vlutsenko.framework.config.driver;

import com.vlutsenko.framework.config.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.vlutsenko.framework.config.scope.ScopeConstants.WEBDRIVER_SCOPE;

@LazyConfiguration
@Profile("!remote")
public class LocalWebDriverFactory implements WebDriverFactory{

    @Value("${browser}")
    private String browser;

    private final Supplier<WebDriver> CHROME = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };
    private final Supplier<WebDriver> FIREFOX = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    private final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    {
        MAP.put(Browsers.CHROME.getName(), CHROME);
        MAP.put(Browsers.FIREFOX.getName(), FIREFOX);
    }

    @Bean
    @Scope(WEBDRIVER_SCOPE)
    public WebDriver getDriver() {
        return MAP.get(browser).get();
    }
}
