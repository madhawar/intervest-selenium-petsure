package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountLogin {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='password']")
    WebElement Password;

    @FindBy(xpath = "//*[@id='password1']")
    WebElement NewPassword;

    @FindBy(xpath = "//label[@for='readAgreement']")
    WebElement ReadAgreement;
    
    @FindBy(xpath = "//*[@id='registerBtn']")
    WebElement Register;

    @FindBy(xpath = "//*[@id='signInBtn']")
    WebElement SignIn;

    public MyAccountLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void finishPurchasingPolicyNewUser() {
        NewPassword.sendKeys("January*27");
        ReadAgreement.click();
        Register.click();
    }

    public void finishPurchasingPolicyExistingUser() {
        Password.sendKeys("January*27");
        SignIn.click();
    }


}
