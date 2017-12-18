import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class csvdatadriver {
    WebDriver driver;
    String url="http://www.sogou.com/";
    @BeforeMethod
    public void before(){
        driver=new FirefoxDriver();

    }
    @AfterMethod
    public void after(){
        driver.quit();
    }
    @DataProvider(name = "testdata")
    public static Object[][]testdata()throws IOException{
        return gettestdata("//Users//yu//Documents//maven01//testdata.csv");
    }
    @Test(dataProvider = "testdata")
    public void test(String keyword1,String keyword2,String result){
        driver.get(url);
        driver.findElement(By.id("query")).sendKeys(keyword1+" "+keyword2);
        driver.findElement(By.id("stb")).click();
        //wait
        (new WebDriverWait(driver,60)).until(new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver d){
                return d.findElement(By.id("searchBtn")).isEnabled();
            }
        });
        Assert.assertTrue(driver.getPageSource().contains(result));
    }
    //read csv file as testdata
    public static Object[][]gettestdata(String csvfilename)throws IOException{
        List<Object[]>records=new ArrayList<Object[]>();
        String record;
        //set UTF-8 use bufferedread(input stream) to read csv file content
        BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(csvfilename),"UTF-8"));
        System.out.println(file.readLine());
        file.readLine();
        while ((record=file.readLine())!=null){
            String fileds[]=record.split(",");
            records.add(fileds);

        }
        file.close();
        Object[][]result=new Object[records.size()][];
        //set the row value of result
        for (int i=0;i<records.size();i++){
            result[i]=records.get(i);
           // System.out.println(result[i]);
        }
        return result;

    }

}
