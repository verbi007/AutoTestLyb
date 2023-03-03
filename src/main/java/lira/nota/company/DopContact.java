package lira.nota.company;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DopContact {
    private String id;
    private String phone;
    private String email;
    private String site;
}
