package lira.liraApi.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TypeBusiness {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("NAME")
    private String name;
}
