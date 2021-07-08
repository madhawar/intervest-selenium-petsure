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

public class TestValidations extends PetsureSetup {
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

    @Test()
    public void validate_pet_name() {
        PetDetails objPet = new PetDetails(driver);

        objPet.verifyPetName();
    }

    @Test(dataProvider = "petInfo")
    public void validate_birthday(DataPOJO petInfo) {
        PetDetails objPet = new PetDetails(driver);

        objPet.petsurePageOne();
        objPet.petsurePageTwo(petInfo.getAnimal());
        objPet.verifyPetAge(petInfo.getGender(), petInfo.getBirthDay(), petInfo.getBirthMonth(), petInfo.getBirthYear());
    }

}
