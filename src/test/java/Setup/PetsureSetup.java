package Setup;

import Pages.PetDetails;
import Pages.PolicyDetails;
import Utils.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PetsureSetup {
    protected WebDriver driver;

    PetDetails objPetDetails;
    PolicyDetails objPolicyDetails;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920,1080));
//        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='accept-all']")).click();

        Log.info("Top of the morning to you.");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test(priority = 1)
//    public void navigate_to_homepage_click_on_getstarted() {
//        objPetDetails = new PetDetails(driver);
//        objPetDetails.veryHeader();
//        objPetDetails.clickOnGetStarted();
//    }
//
//    @Test(priority = 2)
//    public void enter_userDetails() {
//        objPolicyDetails = new PolicyDetails(driver);
//        objPolicyDetails.veryHeader();
//        objPolicyDetails.enterFullName("TestUser");
//        objPolicyDetails.enterBusinessEmail("TestUser@gmail.com");
//        objPolicyDetails.enterPasswrod("TestUserPassword");
//    }

}
