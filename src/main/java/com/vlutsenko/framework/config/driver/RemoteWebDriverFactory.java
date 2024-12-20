package com.vlutsenko.framework.config.driver;

import com.vlutsenko.framework.config.annotations.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.vlutsenko.framework.config.scope.ScopeConstants.WEBDRIVER_SCOPE;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverFactory implements WebDriverFactory{

    @Value("${browser}")
    private String browser;
    @Value("${selenium.grid.url}")
    private URL url;

    private final Supplier<RemoteWebDriver> CHROME = () ->
        new RemoteWebDriver(url, new ChromeOptions());
    private final Supplier<RemoteWebDriver> FIREFOX = () ->
        new RemoteWebDriver(url, new FirefoxOptions());

    private final Map<String, Supplier<RemoteWebDriver>> MAP = new HashMap<>();

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
