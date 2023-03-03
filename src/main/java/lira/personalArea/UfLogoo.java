package lira.personalArea;

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

    public UfLogoo setId(int id) {
        this.id = id;
        return this;
    }

    public UfLogoo setSrc(String src) {
        this.src = src;
        return this;
    }

    public UfLogoo setFile(File file) {
        this.file = file;
        return this;
    }
}
