package lira.liraApi.company;

import lira.liraApi.brands.Brand;
import lombok.Data;

import java.util.List;

@Data
public class BrandsDetail {
    private List<Brand> items;
}
