package com.vendo.Utilities;

import com.vendo.Testcases.BaseClass;
import com.vendo.Testcases.BaseClass;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadConfig extends BaseClass {

    public static void uploadfile(String Path) throws AWTException, InterruptedException {

        Thread.sleep(800);
        driver.findElement(By.xpath("//*[text()='File input:']")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        StringSelection image = new StringSelection(Path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }

}
