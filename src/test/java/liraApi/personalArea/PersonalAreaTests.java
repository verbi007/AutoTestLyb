package liraApi.personalArea;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import lira.liraApi.personalArea.TypeBusiness;
import liraApi.ConfigurationLira;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("Личный кабинет")
public class PersonalAreaTests extends Configuration {
    ConfigurationLira configurationLira;

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url");
    }

    @Test(testName = "Контактная информация")
    @Story("Контрактная информация")
    public void contactInfoTest() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("get/")
                .then().log().all()
                .statusCode(200);
    }

    @Test(testName = "Сохранить изменения")
    @Story("Тест сохранения изменений")
    public void saveChanges() {
        configurationLira = new ConfigurationLira();
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(configurationLira.createContactInfo())
                .post("save/")
                .then()
                .statusCode(200);
    }

    @Test(testName = "Сменить пароль")
    @Story("Тест смены пароля")
    public void changePassword() {
        given()
                .contentType(ContentType.JSON)
                .param("PASSWORD", "testTestomPogon9et")
                .param("NEW_PASSWORD", "TakoyPass")
                .param("CONFIRM_PASSWORD", "TakoyPass")
                .when().log().all()
                .get("changePassword/")
                .then().log().all()
                .statusCode(200);

    }


    @Test(testName = "Проверить пароль текущего юзера")
    @Story("Проверка пароля текущего юзера")
    public void checkCurrentUserPassword() {
        given()
                .contentType(ContentType.JSON)
                .param("PASSWORD", System.getProperty("lira.currentPassword"))
                .when().log().all()
                .get("checkPassword/")
                .then().log().all()
                .statusCode(200)
                .body("SUCCESS", is(true));
    }

    @Test(testName = "Проверить юрл на валидность по регулярке")
    @Story("Проверка URL навалидность по регулярке")
    public void checkUrlForValidity() {
        given()
                .contentType(ContentType.JSON)
                .param("URL", System.getProperty("lira.urlYandex"))
                .when().log().all()
                .get("url/")
                .then().log().all()
                .statusCode(200)
                .body(is("true"));
    }

    @Test(testName = "Получить список тип бизнеса")
    @Story("Получить список тип бизнеса")
    public void getAListOfBusinessType() {
        List<TypeBusiness> listBusiness = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("getTypeBusiness/")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("", TypeBusiness.class);

        Assert.assertEquals(listBusiness.get(0).getId(), "133");
        Assert.assertEquals(listBusiness.get(1).getId(), "134");

    }
}
