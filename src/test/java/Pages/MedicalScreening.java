package Pages;

import Utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalScreening {
    WebDriver driver;

    @FindBy(xpath = "//label[@for='yes']")
    WebElement Yes;

    @FindBy(xpath = "//label[@for='no']")
    WebElement No;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement Continue;

    @FindBy(xpath = "//*[@id='confirm']")
    WebElement OKGotIt;

    @FindBy(xpath = "//*[@id='medicalWarningDismiss']")
    WebElement MedicalWarningDismiss;

    @FindBy(xpath = "//*[@id='conditionsearch']")
    WebElement EnterCondition;

    @FindBy(xpath = "//*[@id='btnSearch']")
    WebElement SearchCondition;

    @FindBy(xpath = "//input[@title='Continue']")
    WebElement MedicalContinue;

    @FindBy(xpath = "//*[@id='btnSubmit']")
    WebElement MedicalFinish;

    public MedicalScreening(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Has Intervest visited the vet and/or been prescribed medication in the last 2 years?
    // Is Intervest awaiting a diagnosis, surgery or test results for a condition?
    public void petsureMedical(String visited_vet_prescribed_medication, String awaiting_surgery, String animal) {
        if (visited_vet_prescribed_medication.equals("no")) {
            No.click();
            Continue.click();

            Log.info("MEDICAL COVER NOT REQUIRED.");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (visited_vet_prescribed_medication.equals("yes")){
            if (awaiting_surgery.equals("yes")) {
                Yes.click();
                Continue.click();

                Log.info("MEDICAL COVER NOT PROVIDED.");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Yes.click();
                Continue.click();
                MedicalWarningDismiss.click();

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (awaiting_surgery.equals("no")) {
                Yes.click();
                Continue.click();

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                No.click();
                Continue.click();

                Log.info("NAVIGATING TO MEDICAL SCREENING.");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                driver.switchTo().frame(0);
                switch (animal) {
                    case "cat":
                        EnterCondition.sendKeys("ticks");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        SearchCondition.click();
                        driver.findElement(By.xpath("//button[@title='Ticks (feline)']")).click();
                        driver.findElement(By.xpath("//input[@name='answerNum' and @value='2']")).click();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath("//input[@name='answerNum' and @value='2']")).click();
                        MedicalContinue.click();
                        MedicalFinish.click();
                        Continue.click();
                        Log.info("COMPLETED MEDICAL SCREENING.");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    case "dog":
                        EnterCondition.sendKeys("ticks");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        SearchCondition.click();
                        driver.findElement(By.xpath("//button[@title='Ticks (canine)']")).click();
                        driver.findElement(By.xpath("//input[@name='answerNum' and @value='2']")).click();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        driver.findElement(By.xpath("//input[@name='answerNum' and @value='2']")).click();
                        MedicalContinue.click();
                        MedicalFinish.click();
                        Continue.click();
                        Log.info("COMPLETED MEDICAL SCREENING.");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }


}
