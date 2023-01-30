package com.vendo.Testcases;

import com.vendo.Utilities.ReadPropConfig;
import com.vendo.Utilities.XLConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.vendo.Utilities.XLConfig.setExcelFile;

public class BaseClass {

    static ReadPropConfig readconfig = new ReadPropConfig();
    public static String browser = readconfig.GetBrowser();
    public static String Baseurl = readconfig.getapplicationURL();
    public static Logger log = Logger.getLogger("VENDO 1.0");

    public static WebDriver driver;
    long StartTime;
    long endTime;

    public static String filepath = "./src/main/resources/Datas/TestDatas.xlsx";
    public static XLConfig xlcon = new XLConfig();
    public static String excelfilepath = filepath;

    @BeforeSuite
    public void StartBrowser() throws InterruptedException, AWTException, IOException {

        DOMConfigurator.configure("Log4J.xml");

        if (browser.equalsIgnoreCase("Chrome")) {

            log.info("Chrome is Opened");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            log.info("Firefox is Opened");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {

            log.info("Microsoft Edge is Opened");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.get(Baseurl);
        log.info(Baseurl);
        driver.manage().window().maximize();


    }

    @AfterSuite(enabled = false)
    public void closebrowser() throws InterruptedException {

        driver.quit();
        endTime = System.currentTimeMillis();
        long Totaltime = endTime - StartTime;
        System.out.println("TIMETAKEN:" + Totaltime);
        driver.quit();

    }

    @AfterMethod
    public void captureScreen(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
            File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + ".png");

            FileUtils.copyFile(source, target);
        }

    }

    public String GetRandomNumber() {

        int randomnum1 = ThreadLocalRandom.current().nextInt();
        String randomnum = String.valueOf(randomnum1);

        return randomnum;

    }

    public String GetRandomSpecialCharacters() {

        String Randspecchar = "!@#$%^&*()_+{}";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * Randspecchar.length());
            salt.append(Randspecchar.charAt(index));
        }
        String Randomspecailcharac = salt.toString();
        return Randomspecailcharac;

    }

    public void sheetsetter(String sheetname) throws IOException {

        setExcelFile(filepath,sheetname);
    }
}
