package skillboxApi;

import lombok.Builder;
import lombok.Data;

@Data
public class Image {
    public String src;

    public Image setSrc(String src) {
        this.src = src;
        return this;
    }
}
