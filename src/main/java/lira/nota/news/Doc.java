package lira.nota.news;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Doc {
    private String url;
    private String id;
    private String type;
    private String name;
}
