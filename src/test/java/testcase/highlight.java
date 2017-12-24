package testcase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class highlight {
    WebDriver driver;
    String url;
    @BeforeMethod
    public void before() throws Exception{
        url="http://www.sogou.com";
        driver=new FirefoxDriver();

    }
    @AfterMethod
    public void after() throws Exception{
        driver.quit();
    }
    @Test
    public void test()throws InterruptedException{
        driver.navigate().to(url);
        WebElement input=driver.findElement(By.id("query"));
        WebElement search=driver.findElement(By.id("stb"));
        highlight(input);
        input.sendKeys("test");
        Thread.sleep(3000);
        highlight(search);
        Thread.sleep(3000);
        search.click();
    }
    public void highlight(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"background:yellow;border:2px solid red;");

    }
}
