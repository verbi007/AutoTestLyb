package skillboxApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

abstract public class ConfigurationTest {

    public void  initRestAssured() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("skillboxApi.properties"));
        RestAssured.authentication = RestAssured.basic(System.getProperty("username"), System.getProperty("password")) ;
        RestAssured.baseURI = System.getProperty("url");
    }

    public CardProduct creatProductCard() {
        return new CardProduct()
                .setName("Xiaomi 12")
                .setSlug("12")
                .setManage_stock(true)
                .setStock_quantity(1)
                .setDescription("phone mi12")
                .setPrice("45000")
                .setRegular_price("44500")
                .setSale_price("43900")
                .setImages(creatImage())
                .setCategories(creatCategory());
    }

    public List<Image> creatImage() {
        List<Image> imagesProduct= new ArrayList<>();
        Image img = new Image().setSrc("https://www.notebookcheck-ru.com/uploads/tx_nbc2/Xiaomi12.JPG");
        imagesProduct.add(img);
        return imagesProduct;
    }

    public List<Category> creatCategory() {
        List<Category> categories = new ArrayList<>();
        Category category = new Category()
                .setId(19)
                .setName("Каталог")
                .setSlug("каталог");
        categories.add(category);
        return categories;
    }

    public CardProduct getCardProduct(int id) {
        return given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get(String.valueOf(id))
                .then()
                .statusCode(200)
                .extract().jsonPath().getObject("", CardProduct.class);
    }

}
