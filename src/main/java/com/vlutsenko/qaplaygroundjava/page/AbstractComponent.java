package com.vlutsenko.qaplaygroundjava.page;

import com.vlutsenko.qaplaygroundjava.config.annotations.LazyAutowired;
import com.vlutsenko.qaplaygroundjava.config.driver.WebDriverFactory;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    @LazyAutowired
    protected WebDriverFactory webDriverFactory;
    @LazyAutowired
    protected WebDriverWait wait;
    protected WebDriver driver;

    @PostConstruct
    private void setUpDriver() {
        driver = webDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }


}
