package com.vlutsenko.framework.page;

import com.vlutsenko.framework.config.annotations.LazyAutowired;
import com.vlutsenko.framework.config.driver.WebDriverFactory;
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
    protected void setUpDriver() {
        driver = webDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();


}
