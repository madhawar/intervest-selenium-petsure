package Tests;

import Pages.*;
import Setup.PetsureSetup;
import Utils.DataPOJO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TestPetExtras extends PetsureSetup {
    @DataProvider
    public Object[][] petInfo() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/pet-extra.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petCommon");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(priority=1, dataProvider = "petInfo")
    public void missing_pet(DataPOJO petInfo) {
        PetDetails objPet = new PetDetails(driver);
        MedicalScreening objHealth = new MedicalScreening(driver);
        PolicyDetails objPolicy = new PolicyDetails(driver);
        OwnerDetails objOwner = new OwnerDetails(driver);

        objPet.petsurePageOne(petInfo.getName());
        objPet.petsurePageTwo(petInfo.getAnimal());
        objPet.petsurePageThree(petInfo.getGender(), petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        objPet.petsurePageFour(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
        objPet.petsurePageFive(petInfo.getNeuteredSpayed(), petInfo.getMicrochipped());
        objPet.petsurePageSix(petInfo.getDonation());
        objPet.petsurePageSeven(petInfo.getDentalIllness());
        objHealth.petsureMedical(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());
        objPolicy.petsurePageNine();
        objPolicy.petsurePageTen();
        objPolicy.petsurePageEleven();
        objOwner.ownerDetails();
        objPolicy.petsurePageThirteen();
        objPolicy.verifyMissingPetCover(petInfo.getMicrochipped());
    }

    @Test(priority=2, dataProvider = "petInfo")
    public void dental_illness(DataPOJO petInfo) {
        PetDetails objPet = new PetDetails(driver);
        MedicalScreening objHealth = new MedicalScreening(driver);
        PolicyDetails objPolicy = new PolicyDetails(driver);
        OwnerDetails objOwner = new OwnerDetails(driver);

        objPet.petsurePageOne(petInfo.getName());
        objPet.petsurePageTwo(petInfo.getAnimal());
        objPet.petsurePageThree(petInfo.getGender(), petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        objPet.petsurePageFour(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
        objPet.petsurePageFive(petInfo.getNeuteredSpayed(), petInfo.getMicrochipped());
        objPet.petsurePageSix(petInfo.getDonation());
        objPet.petsurePageSeven(petInfo.getDentalIllness());
        objHealth.petsureMedical(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());
        objPolicy.petsurePageNine();
        objPolicy.petsurePageTen();
        objPolicy.petsurePageEleven();
        objOwner.ownerDetails();
        objPolicy.petsurePageThirteen();
        objPolicy.verifyDentalIllnessCover(petInfo.getDentalIllness());
    }

    @Test(priority=3, dataProvider = "petInfo")
    public void validate_already_covered_pet_details(DataPOJO petInfo) {
        PetDetails objPet = new PetDetails(driver);
        MedicalScreening objHealth = new MedicalScreening(driver);
        PolicyDetails objPolicy = new PolicyDetails(driver);

        objPet.petsurePageOne(petInfo.getName());
        objPet.petsurePageTwo(petInfo.getAnimal());
        objPet.petsurePageThree(petInfo.getGender(), petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        objPet.petsurePageFour(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
        objPet.petsurePageFive(petInfo.getNeuteredSpayed(), petInfo.getMicrochipped());
        objPet.petsurePageSix(petInfo.getDonation());
        objPet.petsurePageSeven(petInfo.getDentalIllness());
        objHealth.petsureMedical(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());
        objPolicy.petsurePageNine();
        objPolicy.verifyAlreadyCoveredPetDetails();
    }

    @Test(priority=3, dataProvider = "petInfo", enabled = false)
    public void already_covered_pet(DataPOJO petInfo) {
        PetDetails objPet = new PetDetails(driver);
        MedicalScreening objHealth = new MedicalScreening(driver);
        PolicyDetails objPolicy = new PolicyDetails(driver);
        OwnerDetails objOwner = new OwnerDetails(driver);
        Payment objPayment = new Payment(driver);
        MyAccountLogin objLogin = new MyAccountLogin(driver);

        objPet.petsurePageOne(petInfo.getName());
        objPet.petsurePageTwo(petInfo.getAnimal());
        objPet.petsurePageThree(petInfo.getGender(), petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        objPet.petsurePageFour(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
        objPet.petsurePageFive(petInfo.getNeuteredSpayed(), petInfo.getMicrochipped());
        objPet.petsurePageSix(petInfo.getDonation());
        objPet.petsurePageSeven(petInfo.getDentalIllness());
        objHealth.petsureMedical(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());
        objPolicy.petsurePageNine();
        objPolicy.petsurePageTenAlreadyCoveredPet();
        objPolicy.petsurePageEleven();
        objOwner.ownerDetails();
        objPolicy.petsurePageThirteen();
        objPolicy.petsurePageFourteen();
        objPolicy.petsurePageFifteen();
        objPayment.paymentGateway();
        objLogin.finishPurchasingPolicyNewUser();
    }

}
