package liraApi.apiForTemplate;

import coreApi.Configuration;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("API для шаблона")
public class ApiForTemplate extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.purchase");
    }

    @Test(testName = "Заявка на покупку бренда")
    @Story("Создание заявки на покупку бренда")
    @Description("Заявка на покупку бренда")
    public void brandPurchaseOrderTest() {
        Map<String, String> params = new HashMap<>();
        params.put("NAME", "test");
        params.put("EMAIL", "text@mail.ru");
        params.put("TEXT", "testText");

        given()
                .params(params)
                .when().log().all()
                .post("addPurchase/")
                .then().log().all()
                .statusCode(200);
    }


    @Test(testName = "Меню футера")
    @Story("Меню футера")
    @Description("Меню футера")
    public void footerMenuTest() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("bottomMenu/")
                .then().log().all()
                .statusCode(200)
                .body("items.88.SECTION_ID", is("88"))
                .body("items.88.NAME", is("О компании"))
                .body("items.88.podmenu.91.DEPTH_LEVEL", is("2"));
    }

    @Test(testName = "Нижнее меню футера")
    @Story("Нижнее меню футера")
    @Description("Нижнее меню футера")
    public void bottomMenuSmallTest() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("bottomMenuSmall/")
                .then().log().all()
                .statusCode(200)
                .body("items.96.NAME", is("Лицензия"))
                .body("items.98.NAME", is("Информация"));
    }

    @Test(testName = "Задать вопрос")
    @Story("Задать вопрос")
    @Description("Задать вопрос")
    public void askAQuestionTest() {
        given()
                .param("NAME", "test")
                .param("EMAIL", "test@test.ru")
                .param("TEXT", "testoviyTest")
                .when().log().all()
                .post("addQuestions/")
                .then().log().all()
                .statusCode(200);
    }



}
