package testcase;

import java.io.File;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class exceldatadriver {
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
        //return gettestdata("//Users//yu//Documents//maven01","xlsxtestdata.xlsx","工作表1");
        return gettestdata("../../../../src/test/testdata","xlsxtestdata.xlsx","工作表1");
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
    public static Object[][]gettestdata(String filepath,String filename,String sheetname)throws IOException{
        File file=new File(filepath+"//"+filename);
        FileInputStream inputStream=new FileInputStream(file);
        Workbook workbook=null;
        //check file is .xlsx or .xls
        String fileextname=filename.substring(filename.indexOf("."));
        //if file is .xlsx,use XSSFWORKBOOK as instancs
        //if file is .xls.use HSSFWORKBOOK as instance
        if (fileextname.equals(".xlsx")){
            workbook =new XSSFWorkbook(inputStream);
        }
        else if (fileextname.equals(".xls")){
            workbook=new HSSFWorkbook(inputStream);
        }
        Sheet sheet= workbook.getSheet(sheetname);
        // the row num of excel is begin with 0
        int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        List<Object[]>records=new ArrayList<Object[]>();
        for (int i=0;i<rowcount+1;i++){
            Row row=sheet.getRow(i);
            String fields[]=new String[row.getLastCellNum()]; //getlastcellnum  get the one-D array size
            for (int j=0;j<row.getLastCellNum();j++){
                fields[j]=row.getCell(j).getStringCellValue();
            }

           records.add(fields);
        }

        Object[][]result=new Object[records.size()][];
        for (int i=0;i<records.size();i++){
            result[i]=records.get(i);
        }
        return result;
    }

}
