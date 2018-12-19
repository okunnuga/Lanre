import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.junit.Assert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    protected static WebDriver driver;
    public static void main(String[]args) {
        System.setProperty("webdriver.chrome.driver","src\\main\\java\\NopCommerce\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

      //  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32");
      // WebDriver driver=new ChromeDriver();
     //   driver.get("https://demo.nopcommerce.com");
      //  driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
      //  driver.manage().window().fullscreen();
     //   driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Prosper");
        driver.findElement(By.id("LastName")).sendKeys("Okunnuga");
        Select dateofBirthDay=new Select(driver.findElement(By.name("DateOfBirthDay")));
        dateofBirthDay.selectByValue("20");
        Select dateofBirthMonth=new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dateofBirthMonth.selectByIndex(10);
        Select dateOfBirthYearYear=new Select(driver.findElement(By.name("DateOfBirthYear")));
        dateOfBirthYearYear.selectByVisibleText("1965");


        DateFormat dateFormat=new SimpleDateFormat("MMddyyyyHHmmss");
        Date date=new Date();
        String date1=dateFormat.format(date);
        driver.findElement(By.id("Email")).sendKeys("prosperokunnuga2010"+date1+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Nigeria01");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Nigeria01");
        driver.findElement(By.id("register-button")).click();

        String actualRegisterSucessfulMessage=driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals("Your registration completed","");
        driver.findElement(By.linkText("logout")).click();
        driver.quit();



    }
}
