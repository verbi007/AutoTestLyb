package liraApi.banner;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import lira.liraApi.banner.Banner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("Баннеры")
public class BannersTest extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.banner");
    }

    @Test(testName = "Баннеры")
    @Story("Вывод списка баннеров")
    public void bannersTest() {
        List<Banner> banners = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("", Banner.class);

        Assert.assertEquals(banners.get(0).getImg(), "/upload/iblock/afe/afe38b003bccd2cf103c36c98efdd715.jpg");
        Assert.assertEquals(banners.get(1).getLocation(), "content");
        Assert.assertEquals(banners.get(2).getPosition(), "1");
    }
}
