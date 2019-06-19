package com.cgi.calculator.utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Hook is standard name in Cucumber to manage <i>before</i> and <i>after</i> code.
 */
public class Hook {

    private static WebDriver driver;
    private static String HUB_URL = "http://localhost:5566/wd/hub";
    private static String HUB_IE_URL = "http://localhost:5567/wd/hub";

    @Before
    public static void setUp() {
        init();
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    private static void init() {
        //initSimpleDriver();
        initChromeRemoteDriver();
        //initIERemoteDriver();


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    private static void initSimpleDriver(){
        //chromedriver must be manually downloaded
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        if (System.getProperty("webdriver.chrome.driver") != null)
            driver = new ChromeDriver();
        else
            throw new RuntimeException("Unknown web driver specified.");
    }

    private static void initChromeRemoteDriver() {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setPlatform(Platform.WINDOWS);
        capability.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private static void initIERemoteDriver() {
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setPlatform(Platform.WINDOWS);
        capability.setBrowserName("internet explorer");
        try {
            driver = new RemoteWebDriver(new URL(HUB_IE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
