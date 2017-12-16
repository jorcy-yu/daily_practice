import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class screenshot {
    WebDriver driver;
    String url;
    @BeforeMethod
    public void before() throws Exception{
        url="http://www.sogou.com/";
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void after() throws Exception{
        driver.quit();
    }
    @Test
    public void Test() throws IOException,InterruptedException{
        driver.navigate().to(url);
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);
        FileUtils.copyFile(screenshot,new File("//Users//yu//Documents//maven01//1.jpg"));
        File input=new File("//Users//yu//Documents//maven01//2.jpg");
        File output=new File("//Users//yu//Documents//maven01//1.jpg");
        BufferedImage buinput=ImageIO.read(input);
        DataBuffer dainput=buinput.getData().getDataBuffer();
        int sizeinput=dainput.getSize();
        BufferedImage buoutput=ImageIO.read(output);
        DataBuffer daoutput=buoutput.getData().getDataBuffer();
        int sizeoutput=daoutput.getSize();
        Boolean match=true;
        if(sizeinput==sizeoutput){
            for (int j=0;j<sizeinput;j++){
                if (dainput.getElem(j)!=daoutput.getElem(j)){
                    match=false;
                    break;
                }
            }
        }
        else
            match=false;
        Assert.assertTrue(match,"not match!");
    }
}
