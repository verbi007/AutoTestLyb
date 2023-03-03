package lira.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDetails {
    @JsonProperty("ID")
    private String id;

    private String name;
    private String companyName;
    private String description;
    private String webSite;
    private String logo;
    private List<String> galleryHeader;
    private String youtube;
    private Object youtubeImg;
    private Object presentation;
    private List<Object> license;
    private String email;
    private String mobile;
    private Object address;
    private Object contaсtsName;
    private BrandsDetail brands;
}
