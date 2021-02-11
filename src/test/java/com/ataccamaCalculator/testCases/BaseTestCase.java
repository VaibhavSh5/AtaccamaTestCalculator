package com.ataccamaCalculator.testCases;

import com.pageObjectWithFactories.base.AtaccamaCalculatorBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTestCase {

    @BeforeTest
    public void intialRun() {

        AtaccamaCalculatorBase.initializeBrowser();

    }


    @AfterTest

    public void closeBrowser() throws InterruptedException {

        Thread.sleep(3000);
        AtaccamaCalculatorBase.quitBrowserSession();


    }


}
