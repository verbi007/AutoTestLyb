package rickAndMorty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
