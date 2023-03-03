package lira.liraApi.search;

import lira.liraApi.search.Item;
import lombok.Data;

import java.util.List;

@Data
public class ResultSearch {
    private String title;
    private String name;
    private List<Item> items;
    private Boolean more;
}
