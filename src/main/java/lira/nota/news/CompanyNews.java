package lira.nota.news;

import lira.nota.company.Company;
import lombok.Data;

import java.util.List;

@Data
public class CompanyNews {
    List<Company> items;
}
