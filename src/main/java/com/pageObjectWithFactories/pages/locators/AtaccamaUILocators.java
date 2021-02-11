package com.pageObjectWithFactories.pages.locators;

import com.pageObjectWithFactories.base.CalculatorLocatorValues;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtaccamaUILocators {

    @FindBy(xpath= CalculatorLocatorValues.Value1_Xpath)
     public WebElement Value1;

    @FindBy(xpath= CalculatorLocatorValues.Value2_Xpath)
    public WebElement Value2;

    @FindBy(xpath= CalculatorLocatorValues.Addition_Xpath)
    public WebElement Addition;

    @FindBy(xpath= CalculatorLocatorValues.Subtraction_Xpath)
    public WebElement Subtraction;

    @FindBy(xpath= CalculatorLocatorValues.Multiplication_Xpath)
    public WebElement Multiplication;

    @FindBy(xpath= CalculatorLocatorValues.Division_Xpath)
    public WebElement Division;

    @FindBy(xpath= CalculatorLocatorValues.Calculate_Xpath)
    public WebElement Calculate;

    @FindBy(xpath= CalculatorLocatorValues.Result_Xpath)
    public WebElement Result;




}
