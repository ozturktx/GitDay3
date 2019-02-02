package Tests;

import com.sun.xml.internal.ws.server.DefaultResourceInjector;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void test1()
    {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        String title=driver.getTitle();
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertEquals(title,"Web Orders");
    }
      @Test
        public void negativeloginTest() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester2");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test2" + Keys.ENTER);
        String errorMsg = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(errorMsg, "Invalid Login or Password.");
    }




    }
@Test
public void logout(){
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
    driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
    driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    driver.findElement(By.id("ctl00_logout")).click();
    String title=driver.getTitle();
    Assert.assertEquals(title,"Web Orders Login");


}
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
