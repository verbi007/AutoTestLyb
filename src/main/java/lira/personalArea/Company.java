package lira.personalArea;

import lombok.Data;

@Data
public class Company {
    private String id;
    private String name;
    private String logo;
    private String detailPage;
    private String[] products;
}
