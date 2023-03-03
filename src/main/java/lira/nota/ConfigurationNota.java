package lira.nota;

import com.github.javafaker.Faker;
import lira.nota.brand.Brand;
import lira.nota.company.Company;
import lira.nota.company.ListElement;
import lira.nota.company.MainUser;
import lira.nota.company.Type;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationNota {
    private Company company;
    private Company companyBrand;
    private Type type;
    private ListElement listElement;

    private Brand brand;
    private Faker faker;

    public Company creationCompany() {
        company = new Company();
        listElement = new ListElement().setEnumId("538").setValue("owner");
        type = new Type().setListElement(listElement);
        company.setName("JumboTest")
                .setType(type)
                .setMainUser(new MainUser().setIdUser("1500").setName("JumboTest").setLogin("JumboTestLogin"));

        return company;
    }

    public Company creationAUniqueCompany() {
        company = new Company();
        faker = new Faker();
        listElement = new ListElement().setEnumId(faker.idNumber().toString()).setValue(faker.name().username());
        type = new Type().setListElement(listElement);
        company.setName(faker.company().name())
                .setType(type)
                .setMainUser(new MainUser().setIdUser(faker.idNumber().toString()).setName(faker.name().nameWithMiddle()).setLogin(faker.name().username()));

        return company;
    }



}
