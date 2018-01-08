package stepDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Login_Test {
    public static WebDriver driver;
    public static String url="http://email.163.com/";
    @Given("^User is on EmailTypeList Page$")
    public void user_is_on_EmailTypeList_Page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(url);
    }

    @When("^User Navigate to (\\d+) Mail Login Page$")
    public void user_Navigate_to_Mail_Login_Page(int arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://mail.126.com");
    }

    @When("^User enter UserName and Password$")
    public void user_enter_UserName_and_Password() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        WebElement username=driver.findElement(By.xpath("//*[@placeholder='邮箱帐号或手机号']"));
        WebElement password=driver.findElement(By.xpath("//*[@placeholder='密码']"));
        WebElement loginbutton=driver.findElement(By.xpath("//*[@id='ldologin']"));
        username.clear();
        password.clear();
        username.sendKeys("testman1978");
        password.sendKeys("wulaoshi1978");
        loginbutton.click();
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        assertTrue(driver.getPageSource().contains("未读邮件"));
        System.out.println("Logout successfully");

    }

    @When("^User Loginout from the Application$")
    public void user_Loginout_from_the_Application() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        WebElement logoutlink=driver.findElement(By.linkText("退出"));
        logoutlink.click();
    }

    @Then("^Message displayed Logout Successfully$")
    public void message_displayed_Logout_Successfully() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        assertTrue(driver.getPageSource().contains("您已成功退出网易邮箱"));
        System.out.println("成功退出");
        driver.quit();
    }

}
