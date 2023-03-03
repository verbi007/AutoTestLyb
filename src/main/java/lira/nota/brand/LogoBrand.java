package lira.nota.brand;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LogoBrand {
    private String url;
    private String id;
    private String type;
    private String name;
    private String resize;
}
