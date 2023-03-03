package rickAndMorty;

import coreApi.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RIckAndMortyTests extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("rickAndMorty.properties", "url");
    }

    @Test(testName = "Get all episodes")
    public void getAllEpisodes() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("/episode")
                .then().log().all()
                .statusCode(200);
    }

    @Test(testName = "search Morty")
    public void searchCharacter() {
        Response resp = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("character/2")
                .then().log().all()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(resp.jsonPath().get("name"), "Morty Smith");

        List<String> episodes = resp.jsonPath().get("episode");
        String lastEpisode = episodes.get(episodes.size()-1);
        int y = 0;
    }

    @Test
    public void getLastEpisodeCharacterLast() {
        Response resp = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("episode/51")
                .then().log().all()
                .statusCode(200)
                .extract().response();

        List<String> characters = resp.jsonPath().get("characters");
        String lastCharacter = characters.get(characters.size()-1);
        int g = 2;
    }
    
}
