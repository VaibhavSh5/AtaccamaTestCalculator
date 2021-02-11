package com.pageObjectWithFactories.utilities;

import com.pageObjectWithFactories.base.AtaccamaCalculatorBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenshot extends AtaccamaCalculatorBase {

    public static Date d;
    public static String timeStamp;
    public static String screenshotName;

    @Test
    public static void grabScreenshot() throws IOException {

        TakesScreenshot screenshot= (TakesScreenshot) driver;

        File my_File= screenshot.getScreenshotAs(OutputType.FILE);


        Date d = new Date();

        timeStamp= d.toString().replace(" ","_").replace(":","_")+".jpg";
        screenshotName= System.getProperty("user.dir")+"/test-output/html/"+timeStamp;

        //Move the file to a particular location;

        FileUtils.copyFile(my_File, new File(System.getProperty("user.dir")+"/test-output/html/"+timeStamp));

        System.out.println("Screenshot is successfully taken!!");
    }
}
