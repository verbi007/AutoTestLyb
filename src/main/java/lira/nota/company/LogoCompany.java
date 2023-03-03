package lira.nota.company;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LogoCompany {
    private String url;
    private String id;
    private String type;
    private String name;
}
