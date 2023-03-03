package SkillboxApi;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import skillboxApi.CardProduct;
import skillboxApi.ConfigurationTest;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SkillboxTest extends ConfigurationTest {

    private CardProduct cardProduct;
    private String idProductCard;
    private String nameProductCard;
    private List<CardProduct> productsCard;


    @BeforeClass
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("skillboxApi.properties"));
        initRestAssured();
    }

    @Test
    public void checkAllProductsCard() {
        productsCard = given()
                .when()
                .log().all()
                .contentType(ContentType.JSON)
                .get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("", CardProduct.class);
        idProductCard = String.valueOf(productsCard.get(0).getId());
        nameProductCard = productsCard.get(0).getName();
    }

    @Test
    public void checkProductCardById() {
        given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .get(idProductCard)
                .then().log().all()
                .statusCode(200)
                .body("name", is(nameProductCard));

    }

    @Test
    public void creationProductCard() {
        cardProduct = creatProductCard();
        cardProduct = given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(cardProduct)
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getObject("", CardProduct.class);

        CardProduct expectedCardProduct = getCardProduct(cardProduct.getId());
        Assert.assertEquals(cardProduct.getName(), expectedCardProduct.getName());

    }
}
