package lira.nota.company;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Type {
    private ListElement listElement;
}
