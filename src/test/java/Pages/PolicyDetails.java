package Pages;

import Utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    @FindBy(xpath = "//*[@id='name-error']")
    WebElement CoveredPetNameError;

    @FindBy(xpath = "//*[@id='month-error']")
    WebElement CoveredPetRenewMonthError;

    @FindBy(xpath = "//*[@id='ageInfoText']")
    WebElement CoveredPetRenewYearError;

    @FindBy(xpath = "//label[@for='todayDate']")
    WebElement Today;

    @FindBy(xpath = "//label[@for='tomorrowDate']")
    WebElement Tomorrow;

    @FindBy(xpath = "//label[@for='monthly']")
    WebElement PayMonthly;

    @FindBy(xpath = "//label[@for='annually']")
    WebElement PayAnnually;

    @FindBy(xpath = "//label[@for='confirmInfo']")
    WebElement Agreement;

    @FindBy(xpath = "//h3[text()='Dental Illness Cover']")
    WebElement DentalIllnessCover;

    @FindBy(xpath = "//label[@for='switch-0FAREWELL_COVER']")
    WebElement FarewellCover;

    @FindBy(xpath = "//label[@for='switch-0TRAVEL_AND_HOLIDAY_COVER']")
    WebElement TravelAndHolidayCover;

    @FindBy(xpath = "//label[@for='switch-0MISSING_PET_COVER']")
    WebElement MissingPetCover;

    public PolicyDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // We've made a few assumptions
    public void petsurePageNine() {
        Yes.click();
        Continue.click();
    }

    // Would you like to cover any other pets?
    public void petsurePageTen() {
        OtherPetsNo.click();
        Continue.click();
    }

    // Would you like to cover any other pets?
    // They already have cover
    public void petsurePageTenAlreadyCoveredPet() {
        String covered_pet = "Togo";
        LocalDate current_date = LocalDate.now();
        int nextYear = current_date.getYear() +1;
        String renew_year = Integer.toString(nextYear);
        int nextMonth = current_date.getMonthValue() +1;
        String renew_month = Integer.toString(nextMonth);

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

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ok, got it']")));
//        WebElement okButton = driver.findElement(By.xpath("//button[text()='ok, got it']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okButton);
//        OKGOTIT.click();

        OtherPetsNo.click();
        Continue.click();
    }

    public void verifyAlreadyCoveredPetDetails() {
        String covered_pet = "Togo Gunaratne ";
        LocalDate current_date = LocalDate.now();
        int previousYear = current_date.getYear() -1;
        String renew_year = Integer.toString(previousYear);

        AlreadyCoveredOtherPets.click();

        CoveredPetName.sendKeys(covered_pet);
        Assert.assertEquals(CoveredPetNameError.getText(), "Invalid input");
        Assert.assertFalse(Confirm.isEnabled());

        CoveredPetRenewMonth.sendKeys("13");
        Assert.assertEquals(CoveredPetRenewMonthError.getText(), "Invalid month");
        Assert.assertFalse(Confirm.isEnabled());

        CoveredPetRenewYear.sendKeys(renew_year);
        Assert.assertEquals(CoveredPetRenewYearError.getText(), "Invalid year");
        Assert.assertFalse(Confirm.isEnabled());
    }

    // When will your policy start?
    public void petsurePageEleven() {
        Tomorrow.click();
        Continue.click();
    }

    // How much vet fee cover would you like for Intervest?
    // How much excess would you like to pay for Intervest if you make a claim?
    // How much Bill Share would you like to pay for Intervest if you make a claim?
    public void petsurePageThirteen() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Continue.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Add a little extra to your policy
    public void petsurePageFourteen() {
        FarewellCover.click();
        TravelAndHolidayCover.click();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Continue.click();
    }

    public void verifyDentalIllnessCover(String dental_illness) {
        boolean dental_illness_cover;

        switch (dental_illness) {
            case "yes" -> {
                try {
                    dental_illness_cover = driver.findElement(By.cssSelector("body")).getText().contains("Dental Illness Cover");
                } catch (NoSuchElementException e){
                    dental_illness_cover = false;
                }
                Assert.assertTrue(dental_illness_cover);
            }
            case "no" -> {
                try {
                    dental_illness_cover = driver.findElement(By.cssSelector("body")).getText().contains("Dental Illness Cover");
                } catch (NoSuchElementException e){
                    dental_illness_cover = false;
                }
                Assert.assertFalse(dental_illness_cover);
            }
        }
    }

    public void verifyMissingPetCover(String microchipped) {
        boolean missing_pet_cover;

        switch (microchipped) {
            case "yes" -> {
                try {
                    missing_pet_cover = driver.findElement(By.cssSelector("body")).getText().contains("Missing Pet Cover");
                } catch (NoSuchElementException e){
                    missing_pet_cover = false;
                }
                Assert.assertTrue(missing_pet_cover);
            }
            case "no" -> {
                try {
                    missing_pet_cover = driver.findElement(By.cssSelector("body")).getText().contains("Missing Pet Cover");
                } catch (NoSuchElementException e){
                    missing_pet_cover = false;
                }
                Assert.assertFalse(missing_pet_cover);
            }
        }
    }

    public void petsurePageFifteen() {
        PayAnnually.click();
        Agreement.click();
        Continue.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
