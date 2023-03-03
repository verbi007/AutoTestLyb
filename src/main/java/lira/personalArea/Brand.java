package lira.personalArea;

import lombok.Data;

import java.util.List;

@Data
public class Brand {
    private String title;
    private String logo;
    private String url;
    private List<Object> gallery;
}
