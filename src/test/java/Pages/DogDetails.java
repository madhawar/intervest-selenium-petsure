package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DogDetails {
    WebDriver driver;

    @FindBy(xpath = "//label[@for='pedigree']")
    WebElement PedigreeDog;

    @FindBy(xpath = "//*[@id='breed']")
    WebElement Breed;

    @FindBy(xpath = "//label[@for='crossBreed']")
    WebElement CrossBreedDog;

    @FindBy(xpath = "//label[@for='notSure']")
    WebElement BreedNotsure;

    @FindBy(xpath = "//*[@id='breedCross']")
    WebElement CrossBreed;

    @FindBy(xpath = "//*[@id='breedCross1']")
    WebElement CrossBreed1;

    @FindBy(xpath = "//*[@id='breedCross2']")
    WebElement CrossBreed2;

    @FindBy(xpath = "//label[@for='mixedBreed']")
    WebElement MixedBreedDog;

    @FindBy(xpath = "//*[@id='breedDominant']")
    WebElement DominantBreed;

    @FindBy(xpath = "//*[@id='weight']")
    WebElement Weight;

    public DogDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
