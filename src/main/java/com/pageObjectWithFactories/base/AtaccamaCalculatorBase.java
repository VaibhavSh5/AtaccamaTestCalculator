package com.pageObjectWithFactories.base;

import com.pageObjectWithFactories.utilities.ExcelReader;
import com.pageObjectWithFactories.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AtaccamaCalculatorBase {

    public static Logger log = Logger.getLogger(AtaccamaCalculatorBase.class);
    public static WebDriver driver;
    public static ExtentReports reports = ExtentManager.getReportInstance();
    public static ExtentTest tests;


    public static ExcelReader reader = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/Excel/PageObjectWithFactoriesDataProvider.xlsx");

    //Method for Initializing the Browser::

    public static void initializeBrowser() {

        tests = reports.startTest("BrowserInitialized");

        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/Properties/log4j.properties");

        if (driver == null) {
            if (ConstantValues.browser.equalsIgnoreCase("Chrome")) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.debug("The URL has been launched using CHROME browser");
                tests.log(LogStatus.INFO, "The URL has been launched using CHROME browser");
            } else if (ConstantValues.browser.equalsIgnoreCase("Firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.debug("The URL has been launched using FIREFOX browser");
                tests.log(LogStatus.INFO, "The URL has been launched using FIREFOX browser");
            } else if (ConstantValues.browser.equalsIgnoreCase("Edge")) {

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                log.debug("The URL has been launched using EDGE browser");
                tests.log(LogStatus.INFO, "The URL has been launched using EDGE browser");
            } else if (ConstantValues.browser.equalsIgnoreCase("Opera")) {

                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                log.debug("The URL has been launched using OPERA browser");
                tests.log(LogStatus.INFO, "The URL has been launched using OPERA browser");

            }
        }
    }

    //Method for checking ASSERTIONS::

    public static void verifyTrue(Object actual, Object expected, String message) {

        try {
            Assert.assertEquals(actual, expected, message);
        } catch (Throwable e) {

            e.printStackTrace();
        }
    }

    //Method for SOFTASSERTIONS::

    public static void softVerify(Object actual, Object expected) {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();

    }


    //Method for clicking the ELEMENT:

    public static void click(WebElement element) {

        element.click();
        log.debug("The element has been successfully clicked: " + element);
        tests.log(LogStatus.INFO, "The element has been successfully clicked: " + element);
    }


    //Method for sending in the Keys::

    public static void type(WebElement element, String value) {

        element.sendKeys(value);
        log.debug("The value has been typed in the field: " + element);
        //tests.log(LogStatus.INFO, "The value has been typed in the field: " + element);

    }

    //Method for clearing the element:

    public static void clearElement(WebElement element) {

        element.clear();


    }

    //IS ELEMENT PRESENT METHOD:

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;

        } catch (Throwable t) {

            return false;
        }
    }

    //METHOD FOR QUITTING THE BROWSER::

    public static void quitBrowserSession() {

        if (driver != null) {

            driver.quit();
            log.debug("The browser session has been killed!");
        }

    }


}
