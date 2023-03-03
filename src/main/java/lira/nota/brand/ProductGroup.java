package lira.nota.brand;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductGroup {
    private String id;
    private String name;
}
