package liraApi.company;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import lira.liraApi.company.Company;
import lira.liraApi.company.CompanyDetails;
import liraApi.ConfigurationLira;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Компании")
public class CompanyBrandTests extends Configuration {
    ConfigurationLira configurationLira;

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.company");
        configurationLira = new ConfigurationLira();
    }

    @Test(testName = "Список компаний с пагинацией")
    @Story("Тест списка компаний с пагинацией")
    public void companyListWithPagination() {
        List<Company> companyList = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("list/")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("items", Company.class);
        Assert.assertEquals(companyList.get(0).getId(), "125");
        Assert.assertEquals(companyList.get(0).getName(), "WildBrain CPLG");
    }

    @Test(testName = "Детальная страницы компании")
    @Story("Тест детальной страницы компании")
    public void companyDetailsPage() {
        List<CompanyDetails> company = given()
                .contentType(ContentType.JSON)
                .param("ID", "143")
                .when().log().all()
                .get("/getDetail")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("", CompanyDetails.class);

        Assert.assertEquals(company.get(0).getId(), "143");
        Assert.assertEquals(company.get(0).getCompanyName(), "Mattel");
    }

    @DataProvider(name = "data-company-search")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "Wargaming", "142", "/upload/uf/5e8/5e8d974d9cc1e25505efdb06474043dd.jpg", "?id=142"},
                                { "Mattel", "143", "/upload/uf/a4f/a4fd1077cd3ab75c39707360976090a1.jpg",  "?id=143" } };
    }

    @Test(testName = "Поиск по названию", dataProvider = "data-company-search")
    @Story("Тест поиска по названию")
    public void searchByName(String nameCompany, String id, String logo, String detailPage) {
        List<Company> company = given()
                .contentType(ContentType.JSON)
                .param("q", nameCompany)
                .when().log().all()
                .get("/search/")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("", Company.class);


        Assert.assertEquals(company.get(0).getName(), nameCompany);
        Assert.assertEquals(company.get(0).getId(), id);
        Assert.assertEquals(company.get(0).getLogo(), logo);
        Assert.assertEquals(company.get(0).getDetailPage(), detailPage);
    }

    @Test(testName = "Поиск по названию")
    @Story("Тест поиска по названию")
    public void searchByEmptySearch() {
        List<Company> company = given()
                .contentType(ContentType.JSON)
                .param("q", "")
                .when().log().all()
                .get("/search/")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("", Company.class);

        Assert.assertFalse(company.isEmpty());
    }

    @Test(testName = "Правый баннер на детальной странице")
    @Story("Тест правого баннера на детальной странице")
    public void rightBannerDetailPage() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("banner/")
                .then().log().all()
                .statusCode(200);
    }
}
