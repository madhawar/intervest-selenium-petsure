package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class PetDetails {
    WebDriver driver;

    @FindBy(xpath = "//label[@for='yes']")
    WebElement Yes;

    @FindBy(xpath = "//label[@for='no']")
    WebElement No;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement Continue;

    @FindBy(xpath = "//*[@id='confirm']")
    WebElement OKGotIt;

    @FindBy(xpath = "//*[@id='petName']")
    WebElement PetName;

    @FindBy(xpath = "//label[@for='cat']")
    WebElement Cat;

    @FindBy(xpath = "//label[@for='dog']")
    WebElement Dog;

    @FindBy(xpath = "//label[@for='male']")
    WebElement Male;

    @FindBy(xpath = "//label[@for='female']")
    WebElement Female;

    @FindBy(xpath = "//*[@id='day']")
    WebElement Day;

    @FindBy(xpath = "//*[@id='month']")
    WebElement Month;

    @FindBy(xpath = "//*[@id='year']")
    WebElement Year;

    @FindBy(xpath = "//label[@for='isMicroChipped-yes']")
    WebElement MicrochipYes;

    @FindBy(xpath = "//label[@for='isMicroChipped-no']")
    WebElement MicrochipNo;

    @FindBy(xpath = "//*[@id='petCost']")
    WebElement PetCost;

    @FindBy(xpath = "//*[@id='medicalWarningDismiss']")
    WebElement MedicalWarningDismiss;

    public PetDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinueButton() {
        Continue.click();
    }

    public void enterPetName() {
        PetName.sendKeys("Togo");
    }

    public void test() {
        Cat.click();
        Continue.click();

        Male.click();
        Day.sendKeys("14");
        Month.sendKeys("10");
        Year.sendKeys("2016");
        Continue.click();

    }

}
