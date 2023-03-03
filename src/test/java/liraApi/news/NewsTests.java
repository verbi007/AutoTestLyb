package liraApi.news;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import lira.liraApi.news.News;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Новости")
public class NewsTests extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.news");
    }

    @Test(testName = "Новости компании")
    @Story("Возврат новостей компании")
    public void companyNews() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("")
                .then().log().all()
                .statusCode(200);
    }

    @Test(testName = "Последние новости")
    @Story("Возврат последних новостей")
    public void lastNews() {
        List<News> newsList = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("lastNews/")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("items", News.class);
    }

}
