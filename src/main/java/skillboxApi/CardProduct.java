package skillboxApi;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CardProduct {
    private Integer id;
    private String name;
    private String slug;
    private Boolean manage_stock;
    private Integer stock_quantity;
    private String description;
    private String price;
    private String regular_price;
    private String sale_price;
    private List<Image> images;
    private List<Category> categories;

    public CardProduct() {
    }

    public CardProduct setId(Integer id) {
        this.id = id;
        return this;
    }

    public CardProduct setName(String name) {
        this.name = name;
        return this;
    }

    public CardProduct setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public CardProduct setManage_stock(Boolean manage_stock) {
        this.manage_stock = manage_stock;
        return this;
    }

    public CardProduct setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
        return this;
    }

    public CardProduct setDescription(String description) {
        this.description = description;
        return this;
    }

    public CardProduct setPrice(String price) {
        this.price = price;
        return this;
    }

    public CardProduct setRegular_price(String regular_price) {
        this.regular_price = regular_price;
        return this;
    }

    public CardProduct setSale_price(String sale_price) {
        this.sale_price = sale_price;
        return this;
    }

    public CardProduct setImages(List<Image> images) {
        this.images = images;
        return this;
    }

    public CardProduct setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }
}
