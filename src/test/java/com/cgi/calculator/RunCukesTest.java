package com.cgi.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;;

/**
 * Runner of BDD test suite.
 * https://testingneeds.wordpress.com/2015/09/15/junit-runner-with-cucumberoptions/
 */
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"}
        ,glue={"classpath:com.cgi.calculator.stepdefinitions","classpath:com.cgi.calculator.utility"}
        ,plugin = {"pretty", "html:target/cucumber"}
)
public class RunCukesTest {

}