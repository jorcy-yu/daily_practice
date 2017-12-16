package Log4j;

import org.testng.annotations.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
public class logmain {
    WebDriver driver;
    String url="http://www.sogou.com";
    @BeforeClass
    public void beforeclass(){
        DOMConfigurator.configure("Log4j.xml");
    }
    @BeforeMethod
    public void beforemethod(){
        driver=new FirefoxDriver();

    }
    @AfterMethod
    public void aftermethod(){
        driver.quit();
    }
    @Test
    public void test(){
        log.starttestcase("test");
        driver.get(url);
        log.info("open sogou");
        driver.findElement(By.id("query")).sendKeys("test");
        log.info("send key words");
        driver.findElement(By.id("stb")).click();
        log.info("click search button");
        log.endtestcase("test");
    }
}
