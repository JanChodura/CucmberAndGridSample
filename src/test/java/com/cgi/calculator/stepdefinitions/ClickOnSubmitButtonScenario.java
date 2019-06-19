package com.cgi.calculator.stepdefinitions;

import com.cgi.calculator.pageobjects.CalculatorPOM;
import com.cgi.calculator.utility.Hook;
import cucumber.api.java.en.And;

/**
 * It has only steps for this Scenario.
 */
public class ClickOnSubmitButtonScenario{

    private CalculatorPOM calculatorPOM;
    private CommonSteps steps;

    public ClickOnSubmitButtonScenario(){
        calculatorPOM = CalculatorPOM.getInstance(Hook.getDriver());
    }

    @And("I submit")
    public void i_click_on_submit_button() {
        calculatorPOM.submit();
    }
}
