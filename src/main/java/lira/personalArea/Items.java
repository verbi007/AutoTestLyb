package lira.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Items {
    @JsonProperty("NAME")
    private String name;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("WORK_COMPANY")
    private String workCompany;

    @JsonProperty("DETAIL_TEXT")
    private String detailText;

    @JsonProperty("URL")
    private String url;
}
