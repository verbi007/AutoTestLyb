package lira.liraApi.authorization;

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

    public ContactInfo setId(String id) {
        this.id = id;
        return this;
    }

    public ContactInfo setName(String name) {
        this.name = name;
        return this;
    }

    public ContactInfo setUfNameOrg(String ufNameOrg) {
        this.ufNameOrg = ufNameOrg;
        return this;
    }

    public ContactInfo setUfDescription(String ufDescription) {
        this.ufDescription = ufDescription;
        return this;
    }

    public ContactInfo setUfTip(String ufTip) {
        this.ufTip = ufTip;
        return this;
    }

    public ContactInfo setUfBank(String ufBank) {
        this.ufBank = ufBank;
        return this;
    }

    public ContactInfo setUfRaschet(String ufRaschet) {
        this.ufRaschet = ufRaschet;
        return this;
    }

    public ContactInfo setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
        return this;
    }

    public ContactInfo setUfKorschet(String ufKorschet) {
        this.ufKorschet = ufKorschet;
        return this;
    }

    public ContactInfo setUfInn(String ufInn) {
        this.ufInn = ufInn;
        return this;
    }

    public ContactInfo setUfKpp(String ufKpp) {
        this.ufKpp = ufKpp;
        return this;
    }

    public ContactInfo setUfBik(String ufBik) {
        UfBik = ufBik;
        return this;
    }

    public ContactInfo setUfOkpo(String ufOkpo) {
        this.ufOkpo = ufOkpo;
        return this;
    }

    public ContactInfo setUfOkved(String ufOkved) {
        this.ufOkved = ufOkved;
        return this;
    }

    public ContactInfo setUfSait(String ufSait) {
        this.ufSait = ufSait;
        return this;
    }

    public ContactInfo setUfLogoo(UfLogoo ufLogoo) {
        this.ufLogoo = ufLogoo;
        return this;
    }

    public ContactInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactInfo setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }
}
