package skillboxApi;

import lombok.Builder;
import lombok.Data;

@Data

public class Category {
    public Integer id;
    public String name;
    public String slug;

    public Category() {
    }

    public Category setId(Integer id) {
        this.id = id;
        return this;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Category setSlug(String slug) {
        this.slug = slug;
        return this;
    }
}
