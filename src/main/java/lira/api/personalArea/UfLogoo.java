package lira.api.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UfLogoo {
    @JsonProperty("ID")
    public int id;

    @JsonProperty("SRC")
    public String src;

    @JsonProperty("FILE")
    public File file;
}
