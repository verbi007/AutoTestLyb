package lira.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class News {

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("CODE")
    private String code;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("DATE_CREATE")
    private String dateCreate;

    @JsonProperty("PREVIEW_TEXT")
    private String previewText;

    @JsonProperty("DETAIL_TEXT")
    private String detailText;

    @JsonProperty("PICTURE")
    private String picture;

    @JsonProperty("PICTURE_SMALL")
    private PictureSmall pictureSmall;
}
