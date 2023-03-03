package notaApi.company;

import coreApi.Configuration;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class NewsTest extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("nota.properties", "url.news");
        authorizationBasic("login", "password");
    }

    @Test(testName = "Получить список новостей")
    public void getAListNews() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("getList/")
                .then().log().all()
                .statusCode(200);
    }


}
