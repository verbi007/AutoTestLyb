package notaApi.company;

import coreApi.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lira.nota.ConfigurationNota;
import lira.nota.company.Company;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CompanyTest extends Configuration {
    List<Company> company;
    ConfigurationNota nota;

    @BeforeClass
    public void setUp() throws IOException {
        initRestAssured("nota.properties", "url.company");
        authorizationBasic("login", "password");
    }

    @Test(testName = "Получить компанию по id")
    public void getACompanyById() {
        company = given()
                .contentType(ContentType.JSON)
                .param("ID", "8973")
                .when().log().all()
                .get("getById/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath()
                .getList("items", Company.class);

        Assert.assertEquals(company.get(0).getId(), "8973", "Неверный id компании");
        Assert.assertEquals(company.get(0).getCode(), "AOKONTI-RUS", "Неверный code компании");
        Assert.assertEquals(company.get(0).getName(), "АО «КОНТИ-РУС»", "Неверный name компании");
        Assert.assertEquals(company.get(0).getMainUser().login, "AOKONTI-RUSlogin", "Неверный mainUser.login компании");
    }

    @Test(testName = "Сохраненить компанию")
    public void saveACompany() {
        nota = new ConfigurationNota();
        Company companyNew = nota.creationCompany();
        given()
                .contentType(ContentType.JSON)
                .body(companyNew)
                .when().log().all()
                .post("add/index.php")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test(testName = "Получить список компаний")
    public void getAListOfCompanies() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("all", "Y")
                .when().log().all()
                .get("getList/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> ids = jsonPath.get("items.id");

        Assert.assertTrue(ids.stream().anyMatch(x -> x.equals(company.get(0).getId())));

    }

    @Test(testName = "Вывести компании для текущего пользователя")
    public void displayCompaniesForTheCurrentUser() {
        Response response = given()
                .when().log().all()
                .get("getByUser/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> logins = jsonPath.get("items.mainUser.login");

        Assert.assertTrue(logins.stream().allMatch(x -> x.equals("a.verbitskaya@notamedia.ru")));
    }
}
