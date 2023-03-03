package notaApi.company;

import coreApi.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lira.nota.brand.Brand;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;


public class BrandTest extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("nota.properties", "url.brand");
        authorizationBasic("login", "password");
    }


    @Test(testName = "Получить бренд по идентификатору")
    public void getBrandById() {
        List<Brand> brand = given()
                .contentType(ContentType.JSON)
                .param("ID", "9091")
                .when().log().all()
                .get("getById/")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("items", Brand.class);

        Assert.assertEquals(brand.get(0).getId(), "9091", "Неверный id бренда");
        Assert.assertEquals(brand.get(0).getAuditorium().getListElement().getEnumId(), "562", "Неверное auditorium.listElement.enumId бренда");
    }

    @Test(testName = "Получить бренд по коду")
    public void getBrandByCode() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("code", "brand-brand")
                .when().log().all()
                .get("getByCode/")
                .then().log().all()
                .statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> code = jsonPath.get("items.code");

        Assert.assertTrue(code.stream().allMatch(x -> x.matches("brand-brand")));
    }


    @DataProvider(name = "data-brand-current-user")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"409"}, {"411"}, {"532"}
        };
    }

    @Test(testName = "Вывести бренд для текущего пользователя", dataProvider = "data-brand-current-user")
    public void displayTheBrandForTheCurrentUser(String id) {
        given()
                .contentType(ContentType.JSON)
                .param("ID", id)
                .when().log().all()
                .get("getByUser/")
                .then().log().all()
                .statusCode(200);
    }


    @DataProvider(name = "data-brand-product")
    public Object[][] dataProviderProduct() {
        return new Object[][] {
                {"9091", "5364"},
                { "7365", "5360"}
        };
    }

    @Test(testName = "Получить список товарных групп бренда", dataProvider = "data-brand-product")
    public void getAListOfBrandProductGroups(String id, String expectedIdProduct) {
        JsonPath jsonPath = given()
                .contentType(ContentType.JSON)
                .param("id", id)
                .when().log().all()
                .get("getProductGroupByBrand/")
                .then().log().all()
                .statusCode(200)
                .extract().response().jsonPath();
        List<String> brands = jsonPath.get("id");

        Assert.assertTrue(brands.stream().anyMatch(x -> x.matches(expectedIdProduct)));
    }

    @Test(testName = "Баннеры на страницу авторизации")
    public void bannersOnLoginPage() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("getByAuth/")
                .then().log().all()
                .statusCode(200);
    }
}
