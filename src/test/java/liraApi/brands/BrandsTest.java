package liraApi.brands;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import lira.liraApi.brands.Brand;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Бренды")
public class BrandsTest extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.brands");
    }

    @Test(testName = "Получить список 16 брендов")
    @Story("Вывод списка брендов")
    public void getListBrandsTest() {
        List<Brand> brands = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("getListImg.php")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("items.items", Brand.class);

        Assert.assertEquals( brands.size(), 16);
    }
}
