package liraApi.catalog;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Epic("Каталог")
public class CatalogTests extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.catalog");
    }

    @Test(testName = "Список брендов с поиском")
    @Story("Тест вывода списка брендов с поиском")
    public void brandsListWithSearchTest() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("search/")
                .then().log().all()
                .statusCode(200);
    }

    @Test(testName = "Список брендов")
    @Story("Тест вывода списка брендов")
    public void brandsListTest() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
