package Pages;

import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;

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

    @FindBy(xpath = "//*[@id='petName-error']")
    WebElement PetNameError;

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

    @FindBy(xpath = "//*[@id='ageInfoText']")
    WebElement PetAgeError;

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

    @FindBy(xpath = "/html/body/div[1]/div/main/div[2]/div[1]/div/fieldset[1]/div/label")
    WebElement Fixing;

    @FindBy(xpath = "//label[@for='isMicroChipped-yes']")
    WebElement MicrochipYes;

    @FindBy(xpath = "//label[@for='isMicroChipped-no']")
    WebElement MicrochipNo;

    @FindBy(xpath = "//*[@id='petCost']")
    WebElement PetCost;

    @FindBy(xpath = "//*[@id='medicalWarningDismiss']")
    WebElement MedicalWarningDismiss;

    private final static String NAME_REQUIRED = "Name is required";
    private final static String NAME_INVALID = "Invalid input";
    private final static String NAME_MIN = "Minimum length should be 2";
    private final static String NAME_MAX = "Maximum length should be 49";

    private final static String AGE_INVALID = "Please enter a valid birthday";
    private final static String AGE_MIN = " must be at least 4 weeks old";

    public PetDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // What's your pet's name?
    public void petsurePageOne(String name) {
        PetName.sendKeys(name);
        Continue.click();
    }

    public void verifyPetName() {
        PetName.clear();
        PetName.sendKeys(Keys.TAB);
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_REQUIRED);

        PetName.clear();
        PetName.sendKeys("Lando Norris");
        Assert.assertTrue(Continue.isDisplayed());

        PetName.clear();
        PetName.sendKeys("Max33");
        Assert.assertTrue(Continue.isDisplayed());

        PetName.clear();
        PetName.sendKeys("44lewis");
        Assert.assertTrue(Continue.isDisplayed());

        PetName.clear();
        PetName.sendKeys("Vet5tel");
        Assert.assertTrue(Continue.isDisplayed());

        PetName.clear();
        PetName.sendKeys("Lando_Norris");
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_INVALID);

        PetName.clear();
        PetName.sendKeys("Lando@Norris");
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_INVALID);

        PetName.clear();
        PetName.sendKeys(" iceman");
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_INVALID);

        PetName.clear();
        PetName.sendKeys("_");
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_INVALID);

        PetName.clear();
        PetName.sendKeys(" ");
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_INVALID);

        PetName.clear();
        PetName.sendKeys("Loremipsumdolorsitametconsecteturadipiscingelitseddoeiusmodtemporincididuntut");
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetNameError.getText(), NAME_MAX);
    }

    // What kind of pet is Intervest?
    public void petsurePageTwo(String animal) {
        switch (animal) {
            case "cat" -> Cat.click();
            case "dog" -> Dog.click();
        }
        Continue.click();
    }

    // What gender is Intervest?
    // When is Intervest's birthday?
    public void petsurePageThree(String gender, String birthday, String birthmonth, String birthyear) {
        switch (gender) {
            case "male" -> Male.click();
            case "female" -> Female.click();
        }

        Day.sendKeys(birthday);
        Month.sendKeys(birthmonth);
        Year.sendKeys(birthyear);
        Continue.click();
    }

    public void verifyPetAge(String gender, String birthday, String birthmonth, String birthyear) {
        LocalDate current_date = LocalDate.now();
        String recentYear = String.valueOf(current_date.getYear() -51);
        String currentYear = String.valueOf(current_date.getYear());
        String nextYear = String.valueOf(current_date.getYear() +1);
        String recentMonth = String.valueOf(current_date.getMonthValue()-2);
        String currentMonth = String.valueOf(current_date.getMonthValue());
        String recentDay = String.valueOf(current_date.getDayOfMonth()-2);

        switch (gender) {
            case "male" -> Male.click();
            case "female" -> Female.click();
        }

        Day.clear();
        Month.clear();
        Year.clear();
        Day.sendKeys("00");
        Month.sendKeys("00");
        Year.sendKeys("0000");
        Year.sendKeys(Keys.TAB);
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetAgeError.getText(), AGE_INVALID);

        Day.clear();
        Month.clear();
        Year.clear();
        Day.sendKeys(recentDay);
        Month.sendKeys(currentMonth);
        Year.sendKeys(currentYear);
        Year.sendKeys(Keys.TAB);
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetAgeError.getText(), AGE_INVALID);

        Day.clear();
        Month.clear();
        Year.clear();
        Year.sendKeys(nextYear);
        Year.sendKeys(Keys.TAB);
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetAgeError.getText(), AGE_INVALID);

        Day.clear();
        Month.clear();
        Year.clear();
        Year.sendKeys(recentYear);
        Year.sendKeys(Keys.TAB);
        Assert.assertFalse(Continue.isDisplayed());
        Assert.assertEquals(PetAgeError.getText(), AGE_INVALID);

        Day.clear();
        Month.clear();
        Year.clear();
        Month.sendKeys(recentMonth);
        Year.sendKeys(currentYear);
        Year.sendKeys(Keys.TAB);
        Assert.assertTrue(Continue.isDisplayed());

        Day.clear();
        Month.clear();
        Year.clear();
        Year.sendKeys(currentYear);
        Year.sendKeys(Keys.TAB);
        Assert.assertTrue(Continue.isDisplayed());
    }

    // What type of cat/ dog is Intervest?
    public void petsurePageFour(String animal, String type, String breed, String dominant_breed) {
        if (animal.equals("cat")) {
            switch (type) {
                case "moggie" -> {
                    MoggieCat.click();
                    Log.info("SELECTED CAT > MOGGIE");
                }
                case "pedigree" -> {
                    PedigreeCat.click();
                    Breed.sendKeys(breed);
                    BreedSelect.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    Log.info("SELECTED CAT > PEDIGREE");
                }
                case "other" -> {
                    OtherCat.click();
                    Breed.sendKeys(breed);
                    BreedSelect.click();
                    driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                    Log.info("SELECTED CAT > OTHER");
                }
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
                    if (dominant_breed.equals("")) {
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
                        driver.findElement(By.xpath("//*[@id='pure-" + breed + "']")).click();
                        BreedCross2.sendKeys(dominant_breed);
                        BreedSelectCross2.click();
                        driver.findElement(By.xpath("//*[@id='pure-" + dominant_breed + "']")).click();
                        Log.info("SELECTED DOG > CROSS BREED > ENTERED TWO CROSS BREEDS");
                    }
                    break;
                case "mixed":
                    switch (dominant_breed) {
                        case "upto10" -> {
                            MixedBreedDog.click();
                            BreedNotsure.click();
                            DogWeight.click();
                            DogWeightOption1.click();
                            Log.info("SELECTED DOG > MIXED BREED > WEIGHT > UP TO 10KG");
                        }
                        case "10to20" -> {
                            MixedBreedDog.click();
                            BreedNotsure.click();
                            DogWeight.click();
                            DogWeightOption2.click();
                            Log.info("SELECTED DOG > MIXED BREED > WEIGHT > 10KG - 20KG");
                        }
                        case "20ormore" -> {
                            MixedBreedDog.click();
                            BreedNotsure.click();
                            DogWeight.click();
                            DogWeightOption3.click();
                            Log.info("SELECTED DOG > MIXED BREED > WEIGHT > 20KG OR MORE");
                        }
                        default -> {
                            MixedBreedDog.click();
                            BreedDominant.sendKeys(dominant_breed);
                            BreedSelectDominant.click();
                            driver.findElement(By.xpath("//*[@id='pure-" + dominant_breed + "']")).click();
                            Log.info("SELECTED DOG > MIXED BREED > ENTERED DOMINANT BREED");
                        }
                    }
                    break;
            }
        }
        Continue.click();
    }

    // Has Intervest been neutered/ spayed?
    // Has Intervest been microchipped?
    public void petsurePageFive(String neutered_spayed, String microchipped) {
        switch (neutered_spayed) {
            case "yes" -> Yes.click();
            case "no" -> No.click();
        }

        switch (microchipped) {
            case "yes" -> {
                MicrochipYes.click();
                Continue.click();
                Log.info("MICROCHIPPED. ELIGIBLE FOR MISSING PET COVER.");
            }
            case "no" -> {
                MicrochipNo.click();
                Continue.click();
                Confirm.click();
                Log.info("NOT MICROCHIPPED. NOT ELIGIBLE FOR MISSING PET COVER.");
            }
        }
    }

    public void verifyFixing(String name, String gender) {
        switch (gender) {
            case "male" -> Assert.assertEquals(Fixing.getText().toLowerCase(), "has " + name + " been neutered?");
            case "female" -> Assert.assertEquals(Fixing.getText().toLowerCase(), "has " + name + " been spayed?");
        }
    }

    // How much did you pay or donate for Intervest?
    public void petsurePageSix(String donation) {
        PetCost.sendKeys(donation);
        Continue.click();
    }

    public void verifyDonation() {
        PetCost.clear();
        PetCost.sendKeys("10001");
        PetCost.sendKeys(Keys.TAB);
        Assert.assertFalse(Continue.isDisplayed());
    }

    // Would you like to cover Intervest for dental illnesses?
    public void petsurePageSeven(String dental_illness) {
        switch (dental_illness) {
            case "yes" -> {
                Yes.click();
                Log.info("DENTAL ILLNESS REQUESTED.DENTAL ILLNESS COVER WILL BEINCLUDED.");
            }
            case "no" -> {
                No.click();
                Log.info("DENTAL ILLNESS NOT REQUESTED. NOT ELIGIBLE FOR DENTAL ILLNESS COVER.");
            }
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
