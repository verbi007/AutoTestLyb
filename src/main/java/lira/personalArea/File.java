package lira.personalArea;

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

    public File setName(String name) {
        this.name = name;
        return this;
    }

    public File setSize(String size) {
        this.size = size;
        return this;
    }

    public File setType(String type) {
        this.type = type;
        return this;
    }

    public File setDescription(String description) {
        this.description = description;
        return this;
    }

    public File setTmpNname(String tmpNname) {
        this.tmpNname = tmpNname;
        return this;
    }

    public File setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }
}
