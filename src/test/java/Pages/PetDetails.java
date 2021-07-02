package Pages;

import Utils.Log;
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
    WebElement BreedSelect;

    @FindBy(xpath = "//*[@id='breedSelectCross']")
    WebElement BreedSelectCross;

    @FindBy(xpath = "//*[@id='breedSelectCross1']")
    WebElement BreedSelectCross1;

    @FindBy(xpath = "//*[@id='breedSelectCross2']")
    WebElement BreedSelectCross2;

    @FindBy(xpath = "//*[@id='breedSelectDominant']")
    WebElement BreedSelectDominant;

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

    public void petsurePageOne() {
        PetName.sendKeys("Togo");
        Continue.click();
    }

    public void petsurePageTwo(String animal) {
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

    public void petsurePageThree(String gender, String birthday, String birthmonth, String birthyear) {
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

    public void petsurePageFour(String animal, String type, String breed, String dominant_breed) {
        if (animal.equals("cat")) {
            switch (type) {
                case "moggie":
                    MoggieCat.click();
                    Log.info("SELECTED CAT > MOGGIE");
                    break;
                case "pedigree":
                    PedigreeCat.click();
                    Breed.sendKeys(breed);
                    BreedSelect.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    Log.info("SELECTED CAT > PEDIGREE");
                    break;
                case "other":
                    OtherCat.click();
                    Breed.sendKeys(breed);
                    BreedSelect.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    Log.info("SELECTED CAT > OTHER");
                    break;
            }
        } else if (animal.equals("dog")) {
            switch (type) {
                case "pedigree":
                    PedigreeDog.click();
                    Breed.sendKeys(breed);
                    BreedSelect.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    Log.info("SELECTED DOG > PEDIGREE");
                    break;
                case "cross":
                    if (dominant_breed == null) {
                        CrossBreedDog.click();
                        BreedCross.sendKeys(breed);
                        BreedSelectCross.click();
                        driver.findElement(By.xpath("//*[@id='cross-" + breed + "']")).click();
                        Log.info("SELECTED DOG > CROSS BREED");
                    }
                    else {
                        CrossBreedDog.click();
                        BreedNotsure.click();

                        BreedCross1.sendKeys(breed);
                        BreedSelectCross1.click();
                        driver.findElement(By.xpath("//*[@id='cross-" + breed + "']")).click();
                        BreedCross2.sendKeys(dominant_breed);
                        BreedSelectCross2.click();
                        driver.findElement(By.xpath("//*[@id='cross-" + dominant_breed + "']")).click();
                        Log.info("SELECTED DOG > CROSS BREED > ENTERED TWO CROSS BREEDS");
                    }
                    break;
                case "mixed":
                    if (dominant_breed != null) {
                        MixedBreedDog.click();
                        BreedDominant.sendKeys(dominant_breed);
                        BreedSelectDominant.click();
                        driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                        Log.info("SELECTED DOG > MIXED BREED > ENTERED DOMINANT BREED");
                    }
                    else {
                        MixedBreedDog.click();
                        BreedNotsure.click();

                        Random r = new Random();
                        int low = 1;
                        int high = 4;
                        int result = r.nextInt(high - low) + low;

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
                    Log.info("SELECTED DOG > MIXED BREED > WEIGHT");
                    }
                    break;
            }
        }
        Continue.click();
    }

    public void petsurePageFive(String neutered_spayed, String microchipped) {
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
                Log.info("MICROCHIPPED. ELIGIBLE FOR MISSING PET COVER.");
                break;
            case "no":
                MicrochipNo.click();
                Continue.click();
                Confirm.click();
                Log.info("NOT MICROCHIPPED. NOT ELIGIBLE FOR MISSING PET COVER.");
                break;
        }
    }

    public void petsurePageSix(String donation) {
        PetCost.sendKeys(donation);
        Continue.click();
    }

    public void petsurePageSeven(String dental_illness) {
        switch (dental_illness) {
            case "yes":
                Yes.click();
                Log.info("DENTAL ILLNESS REQUESTED.DENTAL ILLNESS COVER WILL BEINCLUDED.");
                break;
            case "no":
                No.click();
                Log.info("DENTAL ILLNESS NOT REQUESTED. NOT ELIGIBLE FOR DENTAL ILLNESS COVER.");
                break;
        }
        Continue.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void healthCover(String visited_vet_prescribed_medication, String awaiting_surgery, String animal) {
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        WebElement conditionContinue = driver.findElement(By.xpath("//label[@for='yes']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", conditionContinue);
//        Continue.click();
//    }


}
