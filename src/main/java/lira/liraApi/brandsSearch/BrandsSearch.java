package lira.liraApi.brandsSearch;

import lira.liraApi.news.News;
import lombok.Data;

import java.util.List;

@Data
public class BrandsSearch {
    private List<News> items;
    private Pager pager;
}
