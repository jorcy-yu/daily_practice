package cn.gloryroad;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testcase {
    WebDriver driver;
    String url="http://www.sogou.com";
    @BeforeMethod
    public void before(){
        driver=new FirefoxDriver();
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test
    public void test(){

        driver.get(url+"/");;
        driver.findElement(By.id("query")).sendKeys("test");
        driver.findElement(By.id("stb")).click();
        try {
            Assert.assertTrue(driver.getPageSource().contains("geoway"));
            System.out.println("false but continue...");
        }catch (AssertionError e){
            System.out.println("excute the catch");
            takescreenshot(driver);
        }

    }
    public void takescreenshot(WebDriver driver){
        try {
            Date date=new Date();
            String dirname="//Users//yu//Documents//maven01//"+String.valueOf(dateutil.getyear(date))+"-"
                    +String.valueOf(dateutil.getmonth(date))+"-"+String.valueOf(dateutil.getday(date));
            if (! new File(dirname).exists()){
                fileutil.createdir(dirname);
            }
            String filename=dirname+"//"+String.valueOf(dateutil.gethour(new Date()))+"-"
                    +String.valueOf(dateutil.getminute(new Date()))+"-"+String.valueOf(dateutil.getsecond(new Date()))
                    +".jpg";
            File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcfile,new File(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
