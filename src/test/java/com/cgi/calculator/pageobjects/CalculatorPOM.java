package com.cgi.calculator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Specific Page Object Model for calculator page.
 */
public class CalculatorPOM extends PageObject{
    private static final String PAGE_URL="https://www.christersvensson.com/calculator/";
    private static final String[] NUMBERS = {"noll","one","two","tree","four","five","six","seven","eight","nine"};

    private static CalculatorPOM calculatorPOM;

    /**
     * Each class with steps needs driver.
     * {@link com.cgi.calculator.stepdefinitions.CommonSteps} has to have same driver as scenario with specific steps.
     *
     * @param driver
     */
    private CalculatorPOM(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
    }

    public static CalculatorPOM getInstance(WebDriver driver){
        if(calculatorPOM == null){
            calculatorPOM = new CalculatorPOM(driver);
        }
        return calculatorPOM;
    }

    /**
     * It must be called at the end of each scenario.
     */
    public void destroy(){
        calculatorPOM = null;
    }

    public CalculatorPOM clickNumber(int number){
        By numberBy = By.name(NUMBERS[number]);
        driver.findElement(numberBy).click();
        return this;
    }

    public CalculatorPOM sendStringToLine(String myString){
        By line = By.name("input");
        driver.findElement(line).sendKeys(myString);
        return this;
    }

    public String getLine(){
        By line = By.name("input");
        return driver.findElement(line).getAttribute("value");
    }

    public CalculatorPOM submit(){
        By submit = By.xpath("//form/p[2]/input[33]");
        driver.findElement(submit).click();
        return this;
    }
}
