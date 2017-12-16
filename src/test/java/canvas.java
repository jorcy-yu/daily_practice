import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class canvas {
    WebDriver driver;
    String url="http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_canvas_line";
    @BeforeMethod
    public void before(){
        driver=new FirefoxDriver();
    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
    @Test
    public void test()throws IOException,InterruptedException{
        File capturescreenfile=null;
        driver.get(url);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("var c=document.getElementById('myCanvas');"
        +"var cxt=c.getContext('2d');"+"cxt.fillStyle='#FF0000';"+"cxt.fillRect(0,0,150,150);");
        capturescreenfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(capturescreenfile,new File("//Users//yu//Documents//maven01//4.jpg"));
    }


}
