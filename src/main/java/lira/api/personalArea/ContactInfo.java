package lira.api.personalArea;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactInfo {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("NAME")
    private String name;

    @JsonProperty("UF_NAMEORG")
    private String ufNameOrg;

    @JsonProperty("UF_DESCRIPTION")
    private String ufDescription;

    @JsonProperty("UF_TIP")
    private String ufTip;

    @JsonProperty("UF_BANK")
    private String ufBank;

    @JsonProperty("UF_RASCHET")
    private String ufRaschet;

    @JsonProperty("WORK_COMPANY")
    private String workCompany;

    @JsonProperty("UF_KORSCHET")
    private String ufKorschet;

    @JsonProperty("UF_INN")
    private String ufInn;

    @JsonProperty("UF_KPP")
    private String ufKpp;

    @JsonProperty("UF_BIK")
    private String UfBik;

    @JsonProperty("UF_OKPO")
    private String ufOkpo;

    @JsonProperty("UF_OKVED")
    private String ufOkved;

    @JsonProperty("UF_SAIT")
    private String ufSait;

    @JsonProperty("UF_LOGOO")
    private UfLogoo ufLogoo;

    @JsonProperty("LAST_NAME")
    private String lastName;

    @JsonProperty("SECOND_NAME")
    private String secondName;
}
