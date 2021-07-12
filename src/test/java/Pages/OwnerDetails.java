package Pages;

import Utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;
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

    @FindBy(xpath = "//*[@id='ageInfoText']")
    WebElement AgeError;

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

    private final static String OWNER_AGE_INVALID = "Please enter your Full Date of Birth";
    private final static String OWNER_AGE_MIN = "You must be over 18 to purchase one of our policies";
    private final static String OWNER_AGE_MAX = "You must be under 120 years to purchase one of our policies";

    public OwnerDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Let’s get some of your details
    public void ownerDetails() {
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

    public void verifyOwnerAge() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String email_address = "madhawa_ist+" + dtf.format(now) + "pet@pm.me";

        Select title = new Select(Title);
        title.selectByVisibleText("Mr");

        Firstname.sendKeys("Madhawa");
        Lastname.sendKeys("GenericSL");

        Email.sendKeys(email_address);
        Telephone.sendKeys("0777837227");
        Postcode.sendKeys("NN47YB");
        PostcodeStaysure.click();

        LocalDate current_date = LocalDate.now();
        String maxAge = String.valueOf(current_date.getYear() -121);
        String minAge = String.valueOf(current_date.getYear() - 17);

        Day.clear();
        Day.sendKeys("27");
        Month.clear();
        Month.sendKeys("05");
        Year.clear();
        Year.sendKeys(maxAge);
        Year.sendKeys(Keys.TAB);
        Assert.assertEquals(AgeError.getText(), OWNER_AGE_MAX);

        Year.clear();
        Year.sendKeys(minAge);
        Year.sendKeys(Keys.TAB);
        Assert.assertEquals(AgeError.getText(), OWNER_AGE_MIN);

        Day.clear();
        Day.sendKeys("32");
        Day.sendKeys(Keys.TAB);
        Assert.assertEquals(AgeError.getText(), OWNER_AGE_INVALID);

        Month.clear();
        Month.sendKeys("13");
        Month.sendKeys(Keys.TAB);
        Assert.assertEquals(AgeError.getText(), OWNER_AGE_INVALID);

        Year.clear();
        Year.sendKeys("0000");
        Year.sendKeys(Keys.TAB);
        Assert.assertEquals(AgeError.getText(), OWNER_AGE_INVALID);
    }

}
