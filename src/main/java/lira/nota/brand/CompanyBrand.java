package lira.nota.brand;

import lira.nota.company.Company;
import lombok.Data;

import java.util.List;

@Data
public class CompanyBrand {
    private List<Company> items;
}
