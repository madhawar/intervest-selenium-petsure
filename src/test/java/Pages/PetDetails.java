package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class PetDetails {
    WebDriver driver;
    By Header=By.xpath("//h1");
    By getStarted=By.xpath("//*[@id='signupModalButton']");

    public PetDetails(WebDriver driver) {
        this.driver=driver;
    }

    public void veryHeader() {
        String getheadertext=driver.findElement(Header).getText();
        assertEquals("App & Browser Testing Made Easy", getheadertext);
    }
    public void clickOnGetStarted() {
        driver.findElement(getStarted).click();
    }

}
