package lira.nota.company;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Company {
    private String id;
    private String code;
    private Role role;
    private String name;
    private Type type;
    private String description;
    private String site;
    private LogoCompany logo;
    private String slider;
    private String video;
    private String videoImg;
    private String staff;
    private MainUser mainUser;
    private String docs;
    private String presentation;
    private String reviews;
    private String address;
    private String urNameFull;
    private String urNameShort;
    private String addressFact;
    private String mailAddress;
    private String bik;
    private String okpo;
    private String okved;
    private String kor;
    private String paymentAccount;
    private String inn;
    private String kpp;
    private String bank;
    private List<DopContact> dopContacts;
    private String socialTelegram;
    private String socialVk;
    private String socialTikTok;
    private String socialYoutube;
    private String videoBlock;
    private String pictures;
    private License license;
    private String descriptionNoTags;


}
