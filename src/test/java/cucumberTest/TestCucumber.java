package cucumberTest;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCucumber {
    public static WebDriver driver;
    public static String url="http://email.163.com/";
    @Before
    public void setup(){
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void test()throws InterruptedException{
        driver.get(url);
        driver.get("http://mail.126.com");
        WebElement username=driver.findElement(By.xpath("//*[@id='idInput']"));
        WebElement password=driver.findElement(By.xpath("//*[@id='pwdInput']"));
        WebElement loginbutton=driver.findElement(By.xpath("//*[@id='loginBtn']"));
        username.clear();
        password.clear();
        username.sendKeys("testman1978");
        password.sendKeys("wulaoshi1978");
        loginbutton.click();
        Thread.sleep(5000);
        assertTrue(driver.getPageSource().contains("未读邮件"));
        System.out.println("Logout successfully");
        Thread.sleep(5000);
        WebElement logoutlink=driver.findElement(By.linkText("退出"));
        logoutlink.click();
        Thread.sleep(5000);
        assertTrue(driver.getPageSource().contains("您已成功退出网易邮箱"));
        System.out.println("成功退出");
        driver.quit();
    }
    @After
    public void teardown(){
        driver.quit();
    }
}

