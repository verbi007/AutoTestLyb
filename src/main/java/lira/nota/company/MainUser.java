package lira.nota.company;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MainUser {
    public String idUser;
    public String name;
    public String lastName;
    public String secondName;
    public String login;
    public String nameUser;
    public boolean mainStaff;
    public String position;
    public String role;
    public LogoCompany logo;
    public String resume;
    public String mobile;
    public String email;
    public String active;
    public String task;
    public String taskList;
    public String password;
    public String passwordConfirm;
    public String otherCompany;
}
