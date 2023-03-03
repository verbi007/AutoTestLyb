package liraApi.personalArea;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("Личный кабинет")
public class News extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.lk.news");
    }

    @Test(testName = "Получить список новостей")
    @Story("Получить список новостей")
    public void getNewsList() {
        Map<String, Integer> params = new HashMap<>();
        params.put("nPageSize", 5);
        params.put("iNumPage", 10);
        params.put("ID", 2025);
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .params(params)
                .get("getlist/")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("PAGER.PAGE", is(10));
    }
}
