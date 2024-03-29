package Setup;

import Pages.MedicalScreening;
import Pages.PetDetails;
import Pages.PolicyDetails;
import Utils.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PetsureSetup {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("browser");
        String url = "https://" + System.getProperty("environment") + "/pet-name";

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        if (browser.equalsIgnoreCase("headless")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("msedge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            Log.error("UNABLE TO INITIATE WEB BROWSER.");
        }

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='accept-all']")).click();

        String version = driver.findElement(By.cssSelector(".sticky-ver-label")).getText();
        Log.info("Petsure v" + version);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
