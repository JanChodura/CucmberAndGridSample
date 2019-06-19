package com.cgi.calculator.stepdefinitions;

import com.cgi.calculator.pageobjects.CalculatorPOM;
import com.cgi.calculator.utility.Hook;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Set of steps used for more scenarios.
 */
public class CommonSteps {

    private CalculatorPOM calculatorPOM;


    public CommonSteps(){
        calculatorPOM = CalculatorPOM.getInstance(Hook.getDriver());
    }

    /**
     * After one each scenario it needs to get back to default state.
     */
    @After
    public void destroy(){
        calculatorPOM.destroy();
    }

    @Given("empty line")
    public void isEmptyLine(){
        assertThat(calculatorPOM.getLine(), is(""));
    }

    /**
     * It uses regular expressions for clicking on number buttons
     * https://cucumber.io/docs/cucumber/cucumber-expressions/
     * @param buttonNumber
     */
    @When("I click on number \"{int}\" button")
    public void i_click_on_number_button(int buttonNumber) {
        calculatorPOM.clickNumber(buttonNumber);
    }

    /**
     * It uses regex for typing words on calculator line.
     * @param word
     */
    @When("I type \"{word}\"")
    public void i_type(String word) {
        calculatorPOM.sendStringToLine(word);
    }

    /**
     * It uses regex for checking any result on calculator line.
     * @param expected
     */
    @Then("I expect on line \"{word}\"")
    public void i_validate_calculator_line(String expected){
        assertThat(calculatorPOM.getLine(), is(expected));
    }
}
