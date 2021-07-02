package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

public class PolicyDetails {
    WebDriver driver;

    @FindBy(xpath = "//label[@for='yes']")
    WebElement Yes;

    @FindBy(xpath = "//label[@for='no']")
    WebElement No;

    @FindBy(xpath = "//label[@for='yesVisited']")
    WebElement OtherPetsYes;

    @FindBy(xpath = "//label[@for='noVisited']")
    WebElement OtherPetsNo;

    @FindBy(xpath = "//a[contains(@data-target, '#defaultModal')]")
    WebElement AlreadyCoveredOtherPets;

    @FindBy(xpath = "//*[@id='name']")
    WebElement CoveredPetName;

    @FindBy(xpath = "//*[@id='month']")
    WebElement CoveredPetRenewMonth;

    @FindBy(xpath = "//*[@id='year']")
    WebElement CoveredPetRenewYear;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement Continue;

    @FindBy(xpath = "//*[@id='confirm']")
    WebElement Confirm;

    @FindBy(xpath = "//button[text()='ok, got it']")
    WebElement OKGOTIT;

    @FindBy(xpath = "//label[@for='todayDate']")
    WebElement Today;

    @FindBy(xpath = "//label[@for='tomorrowDate']")
    WebElement Tomorrow;

    public PolicyDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void agreeToAssumptions() {
        Yes.click();
        Continue.click();
    }

    public void noOtherPets() {
        OtherPetsNo.click();
        Continue.click();
    }

    public void alreadyCoveredPet() {
        String covered_pet = "Togo";
        LocalDate current_date = LocalDate.now();
        int currentYear = current_date.getYear() +1;
        String renew_year = Integer.toString(currentYear);
        int currentMonth = current_date.getMonthValue() +1;
        String renew_month = Integer.toString(currentMonth);

        AlreadyCoveredOtherPets.click();
        CoveredPetName.sendKeys(covered_pet);
        CoveredPetRenewMonth.sendKeys(renew_month);
        CoveredPetRenewYear.sendKeys(renew_year);
        Confirm.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OKGOTIT.click();

        OtherPetsNo.click();
        Continue.click();
    }

    public void policyStartDate() {
        Tomorrow.click();
        Continue.click();
    }

}
