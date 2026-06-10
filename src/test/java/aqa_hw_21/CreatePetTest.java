package aqa_hw_21;

import aqa_hw_21.dto.CategoryDto;
import aqa_hw_21.dto.PetDto;
import aqa_hw_21.dto.TagDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CreatePetTest {

    @Test
    public void verifyPetCanBeCreated() {
        int petIdToCreate = 1114;
        int categoryId = 13;
        String categoryName = "Mops";
        CategoryDto categoryDto = new CategoryDto(categoryId, categoryName);
        String petName = "Chechel";
        List<String> photoUrls = List.of(
                "https://pixabay.com/photos/dog-puppy-dachshund-wiener-4159596/",
                "https://pixers.co.nz/stickers/red-dog-breed-dachshund-70996771"
        );
        List<TagDto> tags = List.of(new TagDto(32, "Little"));
        String status = "available";

        PetDto petToCreate = new PetDto(
                petIdToCreate,
                categoryDto,
                petName,
                photoUrls,
                tags,
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

        Assert.assertEquals(previouslyCreatedPetDto.getId(), petIdToCreate);
        Assert.assertEquals(previouslyCreatedPetDto.getCategory().getId(), categoryId);
        Assert.assertEquals(previouslyCreatedPetDto.getCategory().getName(), categoryName);
        Assert.assertEquals(previouslyCreatedPetDto.getName(), petName);
        Assert.assertEquals(previouslyCreatedPetDto.getStatus(), status);
    }
}
