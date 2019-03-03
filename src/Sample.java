import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Sample {
    WebDriver webDriver=null;

    @Test(dataProvider = "db")
    public void f(String uname,String pass)throws Exception{

        webDriver=new FirefoxDriver();
        webDriver.get("http://www.demo.guru99.com/V4/");
        webDriver.findElement(By.name("uid")).sendKeys(uname);
        webDriver.findElement(By.name("password")).sendKeys(pass);
        webDriver.findElement(By.name("btnLogin")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        webDriver.findElement(By.linkText("Log out")).click();
        Alert alert=webDriver.switchTo().alert();
        alert.accept();
        webDriver.close();

    }


    @DataProvider
    public Object[][] db()
    {
        return new Object[][]{
                new Object[]{"mngr175232","unubYnU"},
                new Object[]{"mngr175232","unubYna"},
                new Object[]{"mngr175232","unubYnb"},
                new Object[]{"mngr175232","unubYnc"},
        };
    }

    @BeforeTest
    public void beforeTest(){
        webDriver=new FirefoxDriver();
        webDriver.get("http://www.demo.guru99.com/V4/");
    }
    @AfterTest
    public void afterTest(){
        webDriver.close();
    }

}

