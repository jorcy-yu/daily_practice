package testcase;

import static org.junit.Assert.*;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RobotTest {

    WebDriver driver;
    String url;

    @BeforeMethod
    public void BeforeMethod() {
        url="http://www.sogou.com";
        driver=new FirefoxDriver();

    }
    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
    @Test
    public void test() {
        driver .get(url);
        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("query")));
        WebElement inputtext=driver.findElement(By.id("query"));
        waittime(2);
        inputtext.sendKeys("1");
        //paste("test");
        waittime(3);

        presstab();
        waittime(1);
        pressenter();
        waittime(5);

    }
    public void paste(String string) {
        StringSelection stringSelection=new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot=null;
        try {
            robot=new Robot();
        } catch (AWTException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

    }
    public void presstab() {

        Robot robot=null;
        try {
            robot=new Robot();
        } catch (AWTException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

    }
    public void pressenter() {

        Robot robot=null;
        try {
            robot=new Robot();
        } catch (AWTException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void waittime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


