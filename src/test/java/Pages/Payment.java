package Pages;

import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Payment {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='amount']")
    WebElement Amount;

    @FindBy(xpath = "//*[@id='cardholderName']")
    WebElement CardHolder;

    @FindBy(xpath = "//*[@id='cardNumber']")
    WebElement CardNumber;

    @FindBy(xpath = "//*[@id='expiryMonth']")
    WebElement Month;

    @FindBy(xpath = "//*[@id='expiryYear']")
    WebElement Year;

    @FindBy(xpath = "//*[@id='csc']")
    WebElement CVV;

    @FindBy(xpath = "//*[@id='btnCancel']")
    WebElement Back;

    @FindBy(xpath = "//*[@id='btnSubmit']")
    WebElement Submit;

    public Payment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void paymentGateway() {
        driver.switchTo().frame(0);

        String final_amount = Amount.getText();

        CardHolder.sendKeys("Madhawa Ratnayake");

        String[] splitCC = ("4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1").split("\\s+");
        for (String s : splitCC) {
            CardNumber.sendKeys(s);
        }

        Select month = new Select(Month);
        month.selectByValue("03");

        Select year = new Select(Year);
        year.selectByValue("2030");

        CVV.sendKeys("737");

        Submit.click();

        driver.switchTo().defaultContent();
        Log.info("Final Amount: " + final_amount);
    }
}
