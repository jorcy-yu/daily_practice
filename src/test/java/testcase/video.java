package testcase;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class video {
    public WebDriver driver;
    String url="http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_video_simple";
    @BeforeMethod
    public void beforemeathod(){
        driver=new FirefoxDriver();
    }
    @AfterMethod
    public void aftermeathod(){
        driver.quit();
    }
    @Test
    public void test()throws InterruptedException,IOException{
        File capturesreenfile=null;
        driver.get(url);
        System.out.println(driver.getPageSource());
        WebElement videoplayer=driver.findElement(By.tagName("video"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String videosrc=(String)js.executeScript("return arguments[0].currentSrc;",videoplayer);
        System.out.println(videosrc);
        Assert.assertEquals("http://www.w3school.com.cn/i/movie.ogg",videosrc);
        Double playtime=(Double)js.executeScript("return arguments[0].duration;",videoplayer);
        System.out.println(playtime.intValue());
        Thread.sleep(10000);
        js.executeScript("return arguments[0].play();",videoplayer);
        Thread.sleep(2000);
        js.executeScript("return arguments[0].pause()",videoplayer);
        Thread.sleep(3000);
        capturesreenfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(capturesreenfile,new File("//Users//yu//Documents//maven01//3.jpg"));
    }
}
