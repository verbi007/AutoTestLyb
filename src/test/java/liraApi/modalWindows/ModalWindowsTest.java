package liraApi.modalWindows;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

import static io.restassured.RestAssured.given;

@Epic("Модальные окна")
public class ModalWindowsTest extends Configuration {

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.modal");
    }

    @Test(testName = "Подписаться на рассылку")
    @Story("Тест подписки на рассылку")
    public void subscribeToNewsletterPositive() {
        given()
                .param("NAME", "test")
                .param("EMAIL", "test@test.com")
                .when().log().all()
                .post("mailNews/")
                .then().log().all()
                .statusCode(200);
    }

    @Test(testName = "Подписаться на рассылку без параметра NAME")
    @Story("Тест подписки на рассылку без параметра NAME")
    public void subscribeToNewsletterNegativeWithoutName() {
        given()
                .param("EMAIL", "test@test.com")
                .when().log().all()
                .post("mailNews/")
                .then().log().all()
                .statusCode(400);
    }

    @Test(testName = "Подписаться на рассылку без параметра EMAIL")
    @Story("Тест подписки на рассылку без параметра EMAIL")
    public void subscribeToNewsletterNegativeWithoutEmail() {
        given()
                .param("NAME", "test")
                .when().log().all()
                .post("mailNews/")
                .then().log().all()
                .statusCode(400);
    }


}
