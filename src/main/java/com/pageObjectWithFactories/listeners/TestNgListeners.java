package com.pageObjectWithFactories.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.pageObjectWithFactories.base.AtaccamaCalculatorBase;
import com.pageObjectWithFactories.utilities.TakeScreenshot;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

import java.io.IOException;

public class TestNgListeners extends AtaccamaCalculatorBase implements ITestListener, ISuiteListener {

    public void onTestStart(ITestResult result) {

        tests= reports.startTest(result.getName().toUpperCase());

    }

     public void onTestSuccess(ITestResult result) {

        tests.log(LogStatus.PASS, result.getName().toUpperCase()+" is PASSED successfully");
        reports.endTest(tests);
        reports.flush();


         try {
             TakeScreenshot.grabScreenshot();
         } catch (IOException e) {
             e.printStackTrace();
         }



     }

    public void onTestFailure(ITestResult result) {


        try {
            TakeScreenshot.grabScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tests.log(LogStatus.FAIL,result.getName().toUpperCase()+" has FAILED"+"Failed with exception: "+result.getThrowable());

        try {
            tests.log(LogStatus.FAIL, String.valueOf(MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshot.screenshotName).build()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        tests.log(LogStatus.FAIL, tests.addScreenCapture(TakeScreenshot.screenshotName));
        reports.endTest(tests);
        reports.flush();
    }

    public void onTestSkipped(ITestResult result) {

        tests.log(LogStatus.SKIP, "The test case has been skipped INTENTIONALLY!!");
        tests.log(LogStatus.SKIP, "Skipping the test: "+result.getName().toUpperCase());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }

    public  void onStart(ISuite suite) {
    }

    public  void onFinish(ISuite suite) {


    }



}
