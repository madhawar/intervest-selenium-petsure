package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatDetails {
    WebDriver driver;

    @FindBy(xpath = "//label[@for='pedigreeCat']")
    WebElement PedigreeCat;

    @FindBy(xpath = "//*[@id='breed']")
    WebElement Breed;

    @FindBy(xpath = "//label[@for='moggy']")
    WebElement MoggieCat;

    @FindBy(xpath = "//label[@for='other']")
    WebElement OtherCat;

    public CatDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
