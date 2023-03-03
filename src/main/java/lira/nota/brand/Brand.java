package lira.nota.brand;

import lira.nota.company.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Brand {
    private String id;
    private String dateCreate;
    private String name;
    private String code;
    private CompanyBrand company;
    private List<ProductGroup> productGroup;
    private String yearCreate;
    private String tagsHighload;
    private LogoBrand logo;
    private String subtitle;
    private String ageFrom;
    private Auditorium auditorium;
    private License license;
    private String ownerHighload;
    private String description;
    private List<LogoCompany> docs;
    private String presentation;
    private LogoBrand slider;
    private String video;
    private String videoImg;
    private List<LogoBrand> pictures;
    private String pictureCase;
    private String cobrandProjects;
    private String reviews;
    private CompanyAgent companyAgent;
    private String companyBuyer;
    private String socialTelegram;
    private String socialVk;
    private String socialTiktok;
    private String socialYoutube;
    private String videoBlock;
    private String subtitleNoTags;
    private String descriptionNoTags;
    private Role role;
    private Type type;
    private String site;
    private String staff;
    private MainUser mainUser;
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
    private String dopContacts;
    private String socialTikTok;
}
