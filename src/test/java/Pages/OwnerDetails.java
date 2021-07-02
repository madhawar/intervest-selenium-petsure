package Pages;

import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OwnerDetails {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement Continue;

    @FindBy(xpath = "//*[@id='title1']")
    WebElement Title;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement Firstname;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement Lastname;

    @FindBy(xpath = "//*[@id='day']")
    WebElement Day;

    @FindBy(xpath = "//*[@id='month']")
    WebElement Month;

    @FindBy(xpath = "//*[@id='year']")
    WebElement Year;

    @FindBy(xpath = "//*[@id='email']")
    WebElement Email;

    @FindBy(xpath = "//*[@id='phone']")
    WebElement Telephone;

    @FindBy(xpath = "//*[@id='postCode']")
    WebElement Postcode;

    @FindBy(xpath = "//*[@id='28403923.00']")
    WebElement PostcodeStaysure;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement Address1;

    @FindBy(xpath = "//*[@id='address2']")
    WebElement Address2;

    @FindBy(xpath = "//*[@id='city']")
    WebElement City;

    @FindBy(xpath = "//*[@id='country1']")
    WebElement Country;

    @FindBy(xpath = "//label[@for='emailPrefer']")
    WebElement promoEmail;

    @FindBy(xpath = "//label[@for='telPrefer']")
    WebElement promoCall;

    @FindBy(xpath = "//label[@for='textPrefer']")
    WebElement promoSMS;

    @FindBy(xpath = "//label[@for='postPrefer']")
    WebElement promoPost;

    public OwnerDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void petsurePageTwelve() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String email_address = "madhawa_ist+" + dtf.format(now) + "pet@pm.me";

        Select title = new Select(Title);
        title.selectByVisibleText("Mr");

        Firstname.sendKeys("Madhawa");
        Lastname.sendKeys("GenericSL");
        Day.sendKeys("27");
        Month.sendKeys("05");
        Year.sendKeys("1989");
        Email.sendKeys(email_address);
        Telephone.sendKeys("0777837227");
        Postcode.sendKeys("NN47YB");
        PostcodeStaysure.click();

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Continue.click();
        Log.info("Username: " + email_address);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
