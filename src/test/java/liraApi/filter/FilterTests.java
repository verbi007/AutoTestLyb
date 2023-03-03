package liraApi.filter;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Epic("Фильтр каталогв")
public class FilterTests extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.filter");
    }

    @Test(testName = "Основной фильтр")
    @Story("Тест основного фильтра")
    public void mainFilter() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);

    }
}
