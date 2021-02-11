package com.pageObjectWithFactories.pages.actions;

import com.pageObjectWithFactories.base.AtaccamaCalculatorBase;

import com.pageObjectWithFactories.base.ConstantValues;
import com.pageObjectWithFactories.pages.locators.AtaccamaUILocators;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class AtaccamaWebUi extends AtaccamaCalculatorBase {


    public static Logger log = Logger.getLogger(AtaccamaWebUi.class);
    public AtaccamaUILocators locators;

    public AtaccamaWebUi() {

        this.locators = new AtaccamaUILocators();
        AjaxElementLocatorFactory ajaxLoc = new AjaxElementLocatorFactory(driver, ConstantValues.waitTimeAjaxLocator);
        PageFactory.initElements(ajaxLoc, locators);

    }

    public void setValue1(String Value1){

        clearElement(locators.Value1);
        type(locators.Value1, Value1);
    }

    public void setValue2(String Value2){

        clearElement(locators.Value2);
        type(locators.Value2, Value2);

    }

    public void assertTest(String Result) {

        softVerify(locators.Result.getAttribute("value"), Result);

    }

    public void setOperation(String operation){

        String validOp[] = {"Subtraction", "Addition", "Division", "Multiplication"};

        if (!ArrayUtils.contains(validOp, operation)) {

            System.err.println("Given operation doesn't exist!!");

        }

        switch (operation) {

            case "Addition": click(locators.Addition);
            log.debug("The operation "+operation+" has been successfully clicked!!");
            break;
            case "Subtraction": click(locators.Subtraction);
            log.debug("The operation "+operation+" has been successfully clicked!!");
            break;
            case "Division": click(locators.Division);
            log.debug("The operation "+operation+" has been successfully clicked!!");
            break;
            case "Multiplication": click(locators.Multiplication);
            log.debug("The operation "+operation+" has been successfully clicked!!");
            break;


        }


    }

    public void clickCalculate(){

        click(locators.Calculate);

    }

    public String getResult(){

        return locators.Result.getAttribute("value");

    }

    public void launchApplication(){

        driver.get(ConstantValues.URL);
        driver.manage().window().maximize();

    }


    public void subtractionOp(String Value1, String Value2, String Result) throws InterruptedException {

        launchApplication();
        setValue1(Value1);
        setValue2(Value2);
        setOperation("Subtraction");
        clickCalculate();
        softVerify(getResult(), Result);
    }

    public void additionOp(String Value1, String Value2, String Result) throws InterruptedException {

        launchApplication();
        setValue1(Value1);
        setValue2(Value2);
        setOperation("Addition");
        clickCalculate();
        softVerify(getResult(), Result);
    }

    public void multiplicationOp(String Value1, String Value2, String Result) throws InterruptedException {

        launchApplication();
        setValue1(Value1);
        setValue2(Value2);
        setOperation("Multiplication");
        clickCalculate();
        softVerify(getResult(), Result);
    }

    public void divisionOp(String Value1, String Value2, String Result) throws InterruptedException {

        launchApplication();
        setValue1(Value1);
        setValue2(Value2);
        setOperation("Division");
        clickCalculate();
        softVerify(getResult(), Result);
    }




}
