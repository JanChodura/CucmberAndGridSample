package com.cgi.calculator.pageobjects;

import org.openqa.selenium.WebDriver;

class PageObject {
    WebDriver driver;

    PageObject(WebDriver driver){
        this.driver = driver;
    }
}