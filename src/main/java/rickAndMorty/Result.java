package rickAndMorty;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Result {
    private int id;
    private String name;
    private String air_date;
    private String episode;
    private ArrayList<String> characters;
    private String url;
    private Date created;





}
