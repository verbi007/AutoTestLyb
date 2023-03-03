package rickAndMorty;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    private Info info;
    private List<Result> results;
}
