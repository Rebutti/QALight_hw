package aqa_hw_21;

import aqa_hw_21.dto.CategoryDto;
import aqa_hw_21.dto.NotFoundPetDto;
import aqa_hw_21.dto.PetDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePetTest {

    @Test
    public void verifyPetCanBeDelete(){

        int petIdToCreate = 1119;
        int categoryId = 13;
        String categoryName = "Mops";
        CategoryDto categoryDto = new CategoryDto(categoryId, categoryName);
        String petName = "Chechel";
        String status = "available";

        PetDto petToCreate = new PetDto(
                petIdToCreate,
                categoryDto,
                petName,
                status
        );

        Response createdPetResponse = given()
                .contentType("application/json")
                .body(petToCreate)
                .post("https://petstore.swagger.io/v2/pet");

        PetDto createdPetDto = createdPetResponse.as(PetDto.class);
        Assert.assertEquals(createdPetDto.getId(), petIdToCreate);

        Response previouslyCreatedPetResponse = given().get("https://petstore.swagger.io/v2/pet/" + petIdToCreate);

        PetDto previouslyCreatedPetDto = previouslyCreatedPetResponse.as(PetDto.class);
        org.junit.Assert.assertEquals(previouslyCreatedPetDto.getId(), petIdToCreate);

        given().delete("https://petstore.swagger.io/v2/pet/" + petIdToCreate);

        Response deletedPetResponse = given().get("https://petstore.swagger.io/v2/pet/" + petIdToCreate);

        NotFoundPetDto notFoundPetDto = deletedPetResponse.as(NotFoundPetDto.class);

        Assert.assertEquals(deletedPetResponse.getStatusCode(), 404);
        Assert.assertEquals(notFoundPetDto.getType(), "error");
        Assert.assertEquals(notFoundPetDto.getMessage(), "Pet not found");

    }

    @Test
    public void checkNotCreatedPet(){
        int imagenPetId = 1123;

        Response notCreatedPetResponse = given().get("https://petstore.swagger.io/v2/pet/" + imagenPetId);

        NotFoundPetDto notFoundPetDto = notCreatedPetResponse.as(NotFoundPetDto.class);

        Assert.assertEquals(notCreatedPetResponse.getStatusCode(), 404);
        Assert.assertEquals(notFoundPetDto.getType(), "error");
        Assert.assertEquals(notFoundPetDto.getMessage(), "Pet not found");
    }

    @Test
    public void deleteNotCreatedPetTest(){
        int imagenPetId = 1123;
        Response deletedPet = given().delete("https://petstore.swagger.io/v2/pet/" + imagenPetId);
        Assert.assertEquals(deletedPet.statusCode(), 404);
    }

}
