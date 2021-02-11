package com.ataccamaCalculator.testCases;

import com.pageObjectWithFactories.base.AtaccamaCalculatorBase;
import com.pageObjectWithFactories.pages.actions.AtaccamaWebUi;
import com.pageObjectWithFactories.utilities.DataProviderFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTestCases extends BaseTestCase {


    @Test(dataProviderClass = DataProviderFile.class, priority = 2, dataProvider = "getData", testName = "Subtraction")
    public void checkSubtraction(String Value1, String Value2, String Result) throws InterruptedException {

        AtaccamaWebUi calci = new AtaccamaWebUi();

        try {
            calci.subtractionOp(Value1, Value2, Result);
        } catch (Exception ex) {

            System.err.println("An exception has occurred");
            Assert.fail(ex.getMessage());

        }

    }

    @Test(dataProviderClass = DataProviderFile.class, priority = 1, dataProvider = "getData", testName = "Addition")
    public void checkAddition(String Value1, String Value2, String Result) throws InterruptedException {

        AtaccamaWebUi calci = new AtaccamaWebUi();

        try {
            calci.additionOp(Value1, Value2, Result);

            calci.assertTest(Result);
        } catch (Exception ex) {

            System.err.println("An exception has occurred");
            Assert.fail("This is the exception message:" + ex.getMessage());
        }

    }

    @Test(dataProviderClass = DataProviderFile.class, priority = 1, dataProvider = "getData", testName = "Multiplication")
    public void checkMultiplication(String Value1, String Value2, String Result) throws InterruptedException {

        AtaccamaWebUi calci = new AtaccamaWebUi();

        try {
            calci.multiplicationOp(Value1, Value2, Result);

            calci.assertTest(Result);
        } catch (Exception ex) {

            System.err.println("An exception has occurred");
            Assert.fail("This is the exception message:" + ex.getMessage());
        }

    }

    @Test(dataProviderClass = DataProviderFile.class, priority = 1, dataProvider = "getData", testName = "Division")
    public void checkDivision(String Value1, String Value2, String Result) throws InterruptedException {

        AtaccamaWebUi calci = new AtaccamaWebUi();

        try {
            calci.divisionOp(Value1, Value2, Result);

            calci.assertTest(Result);
        } catch (Exception ex) {

            System.err.println("An exception has occurred");
            Assert.fail("This is the exception message:" + ex.getMessage());
        }

    }

}
