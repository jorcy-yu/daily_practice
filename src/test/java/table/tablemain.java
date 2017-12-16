package table;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.xml.DOMConfigurator;
public class tablemain {
    WebDriver driver;
    String url="file:///Users/yu/IdeaProjects/case/table.html";
    @BeforeMethod
    public void beforemethod(){
        driver=new FirefoxDriver();
        driver.get(url);
    }
    @AfterMethod
    public void aftermethod(){
        driver.quit();
    }
    @Test
    public void test(){
        WebElement wetable=driver.findElement(By.xpath("//table"));
        table table= new table(wetable);
        WebElement cell=table.getcell(2,3);
        Assert.assertEquals(cell.getText(),"第二行第三列");
        WebElement input=table.getelementincell(2,3,By.tagName("input"));
        input.sendKeys("table");
    }
}
