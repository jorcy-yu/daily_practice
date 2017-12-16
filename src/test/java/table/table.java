package table;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class table {
    private WebElement _table;
    public void settable(WebElement _table){
        this._table=_table;
    }
    public table(WebElement table){
        settable(table);
    }
    public WebElement gettable(){
        return _table;
    }
    public int getrowcount(){
        List<WebElement> tablerows=_table.findElements(By.tagName("tr"));
        return tablerows.size();
    }
    public int getcolumncount(){
        List<WebElement> tablerows=_table.findElements(By.tagName("tr"));
        return tablerows.get(0).findElements(By.tagName("td")).size();
    }
    public WebElement getcell(int row,int col)throws NoSuchElementException{
        try {
            List<WebElement> tablerows=_table.findElements(By.tagName("tr"));
            System.out.println("sum rows:"+tablerows.size());
            System.out.println("rownum:"+row);
            WebElement currentrow=tablerows.get(row-1);
            List<WebElement>tablecols=currentrow.findElements(By.tagName("td"));
            System.out.println("sum cols:"+tablecols.size());
            System.out.println("colsnum:"+col);
            WebElement cell=tablecols.get(col-1);
            return cell;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("can't find elements");
        }

    }
    public WebElement getelementincell(int row,int col,By by)throws NoSuchElementException{
        try {
            List<WebElement>tablerows=_table.findElements(By.tagName("tr"));
            WebElement currentrow=tablerows.get(row-1);
            List<WebElement>tablecols=currentrow.findElements(By.tagName("td"));
            WebElement cell=tablecols.get(col-1);
            return cell.findElement(by);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("can't find elements");
        }
    }
}
