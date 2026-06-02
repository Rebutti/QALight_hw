package aqa_hw_21;

import aqa_hw_21.dto.CategoryDto;
import aqa_hw_21.dto.PetDto;
import aqa_hw_21.dto.TagDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PutPetTests {

    @Test
    public void verifyPetCanBeModified() {
        int petIdToCreate = 1121;
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

        Response createdPet = given().get("https://petstore.swagger.io/v2/pet/" + createdPetDto.getId());

        PetDto obtainedPet = createdPet.as(PetDto.class);

        org.junit.Assert.assertEquals(createdPet.getStatusCode(), 200);
        org.junit.Assert.assertEquals(obtainedPet.getId(), createdPetDto.getId());

        String newName = "Lola";
        String newStatus = "Sold";
        String newCategoryName = "Beagle";
        CategoryDto newCategoryDto = new CategoryDto(categoryId, newCategoryName);
        obtainedPet.setName(newName);
        obtainedPet.setStatus(newStatus);
        obtainedPet.setCategory(newCategoryDto);

        Response updatedPetResponse = given()
                .contentType("application/json")
                .body(obtainedPet)
                .put("https://petstore.swagger.io/v2/pet");

        PetDto updatedPetDto = updatedPetResponse.as(PetDto.class);
        Assert.assertEquals(updatedPetDto.getName(), newName);
        Assert.assertEquals(updatedPetDto.getStatus(), newStatus);
        Assert.assertEquals(updatedPetDto.getCategory().getName(), newCategoryName);


    }

}
