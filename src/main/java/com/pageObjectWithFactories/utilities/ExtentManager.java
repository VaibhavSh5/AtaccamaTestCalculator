package com.pageObjectWithFactories.utilities;


import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {

    private static ExtentReports reports;

    public static ExtentReports getReportInstance(){

        if(reports==null) {

            reports= new ExtentReports(System.getProperty("user.dir")+"/test-output/html/ExtentReport.html", true, DisplayOrder.NEWEST_FIRST);
            reports.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/ExtentConfig/ReportsConfig.xml"));

        }

        return reports;
    }

}
