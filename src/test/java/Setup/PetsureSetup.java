package Setup;

import Pages.MedicalScreening;
import Pages.PetDetails;
import Pages.PolicyDetails;
import Utils.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PetsureSetup {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        String browser = System.getProperty("browser");
        String url = "https://" + System.getProperty("environment") + "/pet-name";

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--disable-site-isolation-trials");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().setSize(new Dimension(1920,1080));
//        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='accept-all']")).click();

        String version = driver.findElement(By.cssSelector(".sticky-ver-label")).getText();
        Log.info("Petsure v" + version);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
//            driver.quit();
        }
    }

}
