package Tests;

import Pages.MedicalScreening;
import Pages.PetDetails;
import Pages.PolicyDetails;
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

public class TestPetDetails extends PetsureSetup {
    @DataProvider
    public Object[][] petInfo() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/pet-min.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petCommon");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @DataProvider
    public Object[][] petDog() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/data/pet-common.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("petDog");
        List<DataPOJO> testData = new Gson().fromJson(dataSet, new TypeToken<List<DataPOJO>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(dataProvider = "petInfo")
    public void navigate_to_homepage_enter_pet_details(DataPOJO petInfo) {
        PetDetails objPetDetails = new PetDetails(driver);
        MedicalScreening objMedicalScreening = new MedicalScreening(driver);
        PolicyDetails objPolicyDetails = new PolicyDetails(driver);

        objPetDetails.enterPetName();
        objPetDetails.selectPetType(petInfo.getAnimal());
        objPetDetails.selectPetGenderAndBirthDay(petInfo.getGender(), petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
        objPetDetails.selectBreed(petInfo.getAnimal(), petInfo.getType(), petInfo.getBreed(), petInfo.getDominantBreed());
//        objPetDetails.dogCrossBreedNotListed(petInfo.getAnimal(), petInfo.getBreed(), petInfo.getDominantBreed());
//        objPetDetails.dogMixedBreedNotListed(petInfo.getAnimal());
        objPetDetails.answerNeuteredOrSpayedQuestionAndMicrochipQuestion(petInfo.getNeuteredSpayed(), petInfo.getMicrochipped());
        objPetDetails.costPaidOrDonated(petInfo.getDonation());
        objPetDetails.dentalIllnessCover(petInfo.getDentalIllness());
//        objPetDetails.healthCover(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());
        objMedicalScreening.healthCover(petInfo.getHealthQuestion1(), petInfo.getHealthQuestion2(), petInfo.getAnimal());
        objPolicyDetails.agreeToAssumptions();
        objPolicyDetails.noOtherPets();
        objPolicyDetails.policyStartDate();


    }

    @Test()
    public void enter_userDetails() {
        PolicyDetails objPolicyDetails = new PolicyDetails(driver);


    }
}
