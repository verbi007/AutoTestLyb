package liraApi.authorization;

import coreApi.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import liraApi.ConfigurationLira;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("Авторизация")
public class Authorizations extends Configuration {
    private ConfigurationLira configurationLira;


    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("liraApi.properties", "url.auth");
    }


    @Test(testName = "Вход в систему (неавторизированный)")
    @Story("Тест входа в систему неавторизованным пользователем")
    public void logInNoAuthTest() {
        configurationLira = new ConfigurationLira();
        configurationLira.logOut();
        given()
                .param("LOGIN", System.getProperty("auth.login"))
                .param("PASSWORD", System.getProperty("auth.password"))
                .when().log().all()
                .get("enter/")
                .prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test(testName = "Вход в систему (авторизированный)")
    @Story("Тест входа в систему авторизованным пользователем")
    public void logInAuthTest() {
        given()
                .param("LOGIN", System.getProperty("auth.login"))
                .param("PASSWORD", System.getProperty("auth.password"))
                .when().log().all()
                .get("enter/")
                .prettyPeek()
                .then()
                .statusCode(400)
                .body("ERROR", is("Вы уже авторизованны!"));
    }

    @Test(testName = "Вход в систему с использованием параметра SAVE=Y")
    @Story("Тест входа в систему с использованием параметра SAVE=Y")
    public void logInSaveMeTest() {
        given()
                .param("LOGIN", System.getProperty("auth.login"))
                .param("PASSWORD", System.getProperty("auth.password"))
                .param("SAVE", "Y")
                .when().log().all()
                .get("enter/")
                .prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test(testName = "Регистрация физического лица")
    @Story("Тест регистрации физического лица")
    public void registrationOfAnIndividualTest() {
        configurationLira = new ConfigurationLira();
        given()
                .params(configurationLira.createIndividualModel())
                .when().log().all()
                .post("regPhis/")
                .then().log().all()
                .statusCode(200);
    }


    @Test(testName = "Регистрация юридического лица")
    @Story("Тест регистрации юридического лица")
    public void registrationOfALegalEntityTest() {
        configurationLira = new ConfigurationLira();
        given()
                .params(configurationLira.createLegalEntity())
                .when().log().all()
                .post("regUr/")
                .then().log().all()
                .statusCode(200);
    }

    @Test(testName = "Подтверждение учетной записи")
    @Story("Тест подтверждения учетной записи")
    public void accountVerificationTest() {
        given()
                .param("id", 428)
                .param("confirm", "88i89tUn")
                .when().log().all()
                .post("confirm/")
                .then().log().all()
                .statusCode(200);
    }


    @Test(testName = "Смена пароля с использованием кода подтверждения")
    @Story("Смена пароля с использованием кода подтверждения")
    public void changePasswordWithConfirmCodeTest() {
        given()
                .param("id", 412)
                .param("code", System.getProperty("confirmCode"))
                .param("new_password", System.getProperty("lira.newPassword"))
                .param("confirm_password", System.getProperty("lira.newPassword"))
                .when().log().all()
                .post("changePassword/")
                .then().log().all()
                .statusCode(200);
    }

}
