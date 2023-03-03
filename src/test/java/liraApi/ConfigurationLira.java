package liraApi;

import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.restassured.http.ContentType;
import lira.liraApi.authorization.ContactInfo;
import lira.liraApi.authorization.File;
import lira.liraApi.authorization.UfLogoo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ConfigurationLira {

    /**
     * Создание контактной информации
     * @return - контактная информация
     */
    public ContactInfo createContactInfo() {
        return new ContactInfo()
                .setId("420")
                .setName("TestTest")
                .setUfNameOrg("")
                .setUfDescription("")
                .setUfTip("")
                .setUfBank("")
                .setUfRaschet("")
                .setWorkCompany("")
                .setUfKorschet("")
                .setUfInn("")
                .setUfKpp("")
                .setUfBik("")
                .setUfOkpo("")
                .setUfOkved("")
                .setUfSait("")
                .setUfLogoo(createUfLogoo())
                .setLastName("")
                .setSecondName("");
    }


    /**
     * Создание логотипа компании
     * @return - логотип компании
     */
    private UfLogoo createUfLogoo() {
        return new UfLogoo()
                .setId(4475)
                .setSrc("/upload/uf/fa8/fa802462fae4d6eb95ab2736c5940f70.png")
                .setFile(createFile());
    }


    /**
     * Создание файла с картинкой лого
     * @return - файл с картинкой лого
     */
    private File createFile() {
        return new File()
                .setName("testImage.png")
                .setSize("55555")
                .setType("image/png")
                .setTmpNname("/srv/sites/lira/lira/upload/uf/fa8/fa802462fae4d6eb95ab2736c5940f70.png")
                .setExternalId("6c8660f5c7d0abde56a34aaf8a79aba0")
                .setDescription("");
    }


    /**
     * Создание физического лица
     * @return - мапа строк
     */
    public Map<String, String> createIndividualModel() {
        Faker faker = new Faker();
        Map<String, String> params = new HashMap<>();
        params.put("name", faker.name().firstName());
        params.put("surname", faker.name().lastName());
        params.put("login", faker.company().name());
        params.put("mobile", faker.phoneNumber().phoneNumber());
        params.put("password", "testerPoshelSpat");
        params.put("confirm", "testerPoshelSpat");
        params.put("email", "test@test.cucumber");
        return params;
    }


    /**
     * Создание юридического лица
     * @return - мапа строк
     */
    public Map<String, String> createLegalEntity() {
        Faker faker = new Faker();
        Map<String, String> params = new HashMap<>();
        params.put("name", faker.name().firstName());
        params.put("surname", faker.name().lastName());
        params.put("login", faker.company().name());
        params.put("mobile", faker.phoneNumber().phoneNumber());
        params.put("password", "testerPoshelSpat");
        params.put("confirm", "testerPoshelSpat");
        params.put("email", "test@test.cucumber");
        params.put("position", faker.lebowski().character());
        params.put("webSite", faker.app().name());
        params.put("address", faker.address().fullAddress());
        params.put("contact", faker.finance().iban());
        return params;
    }


    public void logOut() {
        given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get("logout/")
                .then().log().all()
                .statusCode(200);
    }

}
