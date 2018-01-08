package cucumberTest;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature",glue = {"stepDefinition"},format = {"html:target/cucumber-html-report"})
/* features:设定feature在工程中的路径，Feature表示在工程根目录下
   glue:设定BDD自动化测试代码所在PACKAGE名称
   FORMAT：设定生成HTML格Thread.sleep(5000);
        assertTrue(driver.getPageSource().contains("您已成功退出网易邮箱"));
        System.out.println("成功退出");
        driver.quit();式的报告，并将报告生成路径设为target/cucumber-html-report
 */

public class TestRunner {
}
