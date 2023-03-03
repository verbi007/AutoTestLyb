package lira.personalArea;

import lombok.Data;

@Data
public class ResultSearch {
    private String title;
    private String name;
    private Items items;
    private Boolean more;
}
