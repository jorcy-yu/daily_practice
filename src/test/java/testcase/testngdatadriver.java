package testcase;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testngdatadriver {
    WebDriver driver;
    @DataProvider(name="keywords")
    public static Object[][] words(){
        return new Object[][]{{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};
    }
    @Test(dataProvider = "keywords",groups = {"test1"})
    public void test(String keyword1,String keyword2,String result){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String url="http://www.sogou.com";
        driver.get(url);
        driver.findElement(By.id("query")).sendKeys(keyword1+" "+keyword2);
        driver.findElement(By.id("stb")).click();
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getPageSource().contains(result));
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }



}
