import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookLoginTest {

    public static WebDriver driver = null;

    @BeforeTest
    public void before() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void staffAm() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@name = 'pass']")).sendKeys("xyz");
        driver.findElement(By.xpath("//button[@name = 'login']")).click();

        WebElement yourProfileButton = driver.findElement(By.xpath("//div[@aria-label='Ваш профиль']"));
        boolean yourProfileButtonIsFinded = yourProfileButton.isEnabled();
        System.out.println(yourProfileButtonIsFinded);
        Thread.sleep(2000);

    }

    @AfterMethod
    public void af() {
        driver.quit();

    }

}

