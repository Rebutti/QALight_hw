package aqa_hw_21;

import aqa_hw_21.dto.PetDto;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPetTests {

    @Test
    public void verifyPetEntityCanBeObtained() {
        int petIdToGet = 1111;

        Response response = given().get("https://petstore.swagger.io/v2/pet/" + petIdToGet);

        PetDto obtainedPet = response.as(PetDto.class);

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(obtainedPet.getId(), petIdToGet);
    }
}
