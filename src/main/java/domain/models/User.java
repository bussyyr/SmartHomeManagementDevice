package domain.models;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractModel{
    private String name;
    private String email;
    private String password;
    private List<AutomationRule> automationRules;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.automationRules = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AutomationRule> getAutomationRules() {
        return automationRules;
    }

    public void setAutomationRules(List<AutomationRule> automationRules) {
        this.automationRules = automationRules;
    }
}
