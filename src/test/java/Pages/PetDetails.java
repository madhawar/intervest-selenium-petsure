package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

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
    WebElement Confirm;

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

    @FindBy(xpath = "//label[@for='pedigreeCat']")
    WebElement PedigreeCat;

    @FindBy(xpath = "//label[@for='moggy']")
    WebElement MoggieCat;

    @FindBy(xpath = "//label[@for='other']")
    WebElement OtherCat;

    @FindBy(xpath = "//*[@id='breed']")
    WebElement Breed;

    @FindBy(xpath = "//*[@id='breedSelect']")
    WebElement BreedSearch;

    @FindBy(xpath = "//*[@id='pure-Hello World']")
    WebElement BreedPureList;

    @FindBy(xpath = "//*[@id='cross-Hello World']")
    WebElement BreedCrossList;

    @FindBy(xpath = "//label[@for='pedigree']")
    WebElement PedigreeDog;

    @FindBy(xpath = "//label[@for='crossBreed']")
    WebElement CrossBreedDog;

    @FindBy(xpath = "//label[@for='notSure']")
    WebElement BreedNotsure;

    @FindBy(xpath = "//*[@id='breedCross']")
    WebElement BreedCross;

    @FindBy(xpath = "//*[@id='breedCross1']")
    WebElement BreedCross1;

    @FindBy(xpath = "//*[@id='breedCross2']")
    WebElement BreedCross2;

    @FindBy(xpath = "//label[@for='mixedBreed']")
    WebElement MixedBreedDog;

    @FindBy(xpath = "//*[@id='breedDominant']")
    WebElement BreedDominant;

    @FindBy(xpath = "//*[@id='weight']")
    WebElement DogWeight;

    @FindBy(xpath = "//*[@id='<10']")
    WebElement DogWeightOption1;

    @FindBy(xpath = "//*[@id='10-20']")
    WebElement DogWeightOption2;

    @FindBy(xpath = "//*[@id='20<']")
    WebElement DogWeightOption3;

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

    public void enterPetName() {
        PetName.sendKeys("Togo");
        Continue.click();
    }

    public void selectPetType(String animal) {
        switch (animal) {
            case "cat":
                Cat.click();
                break;
            case "dog":
                Dog.click();
                break;
        }
        Continue.click();
    }

    public void selectPetGenderAndBirthDay(String gender, String birthday, String birthmonth, String birthyear) {
        switch (gender) {
            case "male":
                Male.click();
                break;
            case "female":
                Female.click();
                break;
        }

        Day.sendKeys(birthday);
        Month.sendKeys(birthmonth);
        Year.sendKeys(birthyear);
        Continue.click();
    }

    public void selectBreed(String animal, String type, String breed, String dominant_breed) {
        if (animal.equals("cat")) {
            switch (type) {
                case "moggie":
                    MoggieCat.click();
                    break;
                case "pedigree":
                    PedigreeCat.click();
                    Breed.sendKeys(breed);
                    BreedSearch.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    break;
                case "other":
                    OtherCat.click();
                    Breed.sendKeys(breed);
                    BreedSearch.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    break;
            }
        }
        else if (animal.equals("dog")) {
            switch (type) {
                case "pedigree":
                    PedigreeDog.click();
                    Breed.sendKeys(breed);
                    BreedSearch.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    break;
                case "cross":
                    CrossBreedDog.click();
                    BreedCross.sendKeys(breed);
                    BreedSearch.click();
                    driver.findElement(By.xpath("//*[@id='cross-" + breed + "']")).click();
                    break;
                case "mixed":
                    MixedBreedDog.click();
                    BreedDominant.sendKeys(dominant_breed);
                    BreedSearch.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    break;
            }
        }
        Continue.click();
    }

    public void dogCrossBreedNotListed(String animal, String breed, String dominant_breed) {
        if (animal.equals("dog")) {
            CrossBreedDog.click();
            BreedNotsure.click();

            BreedCross1.sendKeys(breed);
            driver.findElement(By.xpath("//*[@id='cross-" + breed + "']")).click();
            BreedCross2.sendKeys(dominant_breed);
            driver.findElement(By.xpath("//*[@id='cross-" + dominant_breed + "']")).click();
        }
        Continue.click();
    }

    public void dogMixedBreedNotListed(String animal) {
        if (animal.equals("dog")) {
            MixedBreedDog.click();
            BreedNotsure.click();

            Random r = new Random();
            int low = 1;
            int high = 4;
            int result = r.nextInt(high-low) + low;

            switch (result) {
                case 1:
                    DogWeight.click();
                    DogWeightOption1.click();
                    break;
                case 2:
                    DogWeight.click();
                    DogWeightOption2.click();
                    break;
                case 3:
                    DogWeight.click();
                    DogWeightOption3.click();
                    break;
            }
        }
        Continue.click();
    }

    public void answerNeuteredOrSpayedQuestionAndMicrochipQuestion(String neutered_spayed, String microchipped) {
        switch (neutered_spayed) {
            case "yes":
                Yes.click();
                break;
            case "no":
                No.click();
                break;
        }

        switch (microchipped) {
            case "yes":
                MicrochipYes.click();
                Continue.click();
                break;
            case "no":
                MicrochipNo.click();
                Continue.click();
                Confirm.click();
                break;
        }
    }

    public void costPaidOrDonated(String donation) {
        PetCost.sendKeys(donation);
        Continue.click();
    }

    public void dentalIllnessCover(String dental_illness) {
        switch (dental_illness) {
            case "yes":
                Yes.click();
                break;
            case "no":
                No.click();
                break;
        }
        Continue.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void healthCover(String visited_vet_prescribed_medication, String awaiting_surgery, String animal) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement conditionContinue = driver.findElement(By.xpath("//label[@for='yes']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", conditionContinue);
        Continue.click();
    }


}
