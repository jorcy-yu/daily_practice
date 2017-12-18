import java.sql.*;
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

public class mysqldatadriver {
    public WebDriver driver;
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
        return gettestdata("testdata");
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
    public static Object[][]gettestdata(String tablename)throws IOException{
        //download database driver .jar or add dependence
        String database="com.mysql.jdbc.driver";
        String SID="jdbc:mysql://127.0.0.1:3306/gloryroad";
        String user="root";
        String password="gloryroad";
        List<Object[]>records=new ArrayList<Object[]>();
        try {
            //set driver
            Class.forName(database);
            Connection conn=DriverManager.getConnection(SID,user,password);
            if (!conn.isClosed()){
                System.out.println("connect successed!");
                //create statement
                Statement statement=conn.createStatement();
                String sql="select * from " + tablename;
                ResultSet rs=statement.executeQuery(sql);
                ResultSetMetaData remetadata=rs.getMetaData();
                int cols=remetadata.getColumnCount();
                while (rs.next()){
                    String fields[]=new String[cols];
                    int col=0;
                    for (int colidx=0;colidx<cols;colidx++){
                        fields[col]=rs.getString(colidx+1);
                        col++;
                    }
                    records.add(fields);
                    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                }
                rs.close();
                conn.close();
            }
        }catch (ClassNotFoundException e){
            System.out.println("can't find database driver class!");
            e.getStackTrace();
        }catch (SQLException e){
            e.getStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        Object[][]result=new Object[records.size()][];
        for (int i=0;i<records.size();i++){
            result[i]=records.get(i);
        }
        return result;

    }

}

