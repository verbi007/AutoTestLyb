package liraApi.search;

import coreApi.Configuration;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import lira.liraApi.search.Item;
import lira.liraApi.news.News;
import lira.liraApi.search.ResultSearch;
import lira.liraApi.brandsSearch.BrandsSearch;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Поиск")
public class SearchTests extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.search");
    }

    @DataProvider(name = "data-search")
    public Object[][] dataProviderMethod() {
        return new Object[][] {{"Wargaming", "142"}, {"dota", "1456"}};
    }

    @Test(testName = "Поиск по всем полям", dataProvider = "data-search")
    @Story("Тест поиска по всем полям")
    public void searchInAllFields(String value, String id) {
        List<ResultSearch> list = given()
                .param("search", value)
                .when().log().all()
                .post("all.php")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("", ResultSearch.class);
        Assert.assertEquals(list.get(1).getItems().get(0).getId(), id);
    }

    @DataProvider(name = "data-brands-search")
    public Object[][] dataProviderBrandsSearch() {
        return new Object[][] {{"Disney", "1665"}, {"Mattel", "1557"}, {"Аркадий Паровозов", "1445"}};
    }

    @Test(testName = "Поиск по брендам(с пагинацией)", dataProvider = "data-brands-search")
    @Story("Тест поиска по брендам с пагинацией")
    public void brandsSearch(String brandsName, String id) {
        BrandsSearch brandsSearch = given()
                .param("search" , brandsName)
                .param("PAGE", "1")
                .when().log().all()
                .post("brands.php")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getObject("", BrandsSearch.class);

        Assert.assertEquals(brandsSearch.getItems().get(0).getId(), id);

    }

    @DataProvider(name = "data-company-search")
    public Object[][] dataProviderCompanySearch() {
        return new Object[][] {{"Disney", "144"}, {"Mattel", "143"}, {"JMB", "411"}};
    }

    @Test(testName = "Поиск по компаниям", dataProvider = "data-company-search")
    @Story("Тест поиска по компаниям")
    public void companySearch(String companyName, String id) {
        List<Item> companies = given()
                .param("search" , companyName)
                .param("PAGE", "1")
                .when().log().all()
                .post("companies.php")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("items", Item.class);

        Assert.assertEquals(companies.get(0).getId(), id);
    }

    @DataProvider(name = "data-news-search")
    public Object[][] dataProviderNewsSearch() {
        return new Object[][] {{"ЯРКО", "2025"}, {"три кота", "2026"}};
    }

    @Test(testName = "Поиск по новостям", dataProvider = "data-news-search")
    @Story("Тест поиска по новостям")
    public void newsSearch(String newsName, String id) {
        List<News> news = given()
                .contentType(ContentType.JSON)
                .param("search" , newsName)
                .param("PAGE", "")
                .when().log().all()
                .post("news.php")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("items", News.class);

        Assert.assertEquals(news.get(0).getId(), id);
    }

}
