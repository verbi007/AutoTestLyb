package lira.liraApi.brandsSearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pager {
    @JsonProperty("PAGE")
    private String page;

    @JsonProperty("PAGE_COUNT")
    private String pageCount;

    @JsonProperty("COUNT")
    private String count;
}
