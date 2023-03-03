package lira.api.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class File {
    public String name;

    public String size;

    public String type;

    public String description;

    @JsonProperty("tmp_name")
    public String tmpNname;

    @JsonProperty("external_id")
    public String externalId;
}
