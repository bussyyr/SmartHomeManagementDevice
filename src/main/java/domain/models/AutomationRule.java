package domain.models;

import domain.models.action.Action;
import domain.models.condition.Condition;
import domain.models.device.Device;

import java.util.ArrayList;
import java.util.List;

public class AutomationRule {
    private int automationRuleId;
    private String name;
    private List<Device> devices;
    private Condition condition;
    private Action action;

    public AutomationRule(int automationRuleId, String name, Condition condition, Action action) {
        this.automationRuleId = automationRuleId;
        this.name = name;
        this.condition = condition;
        this.action = action;
        this.devices=new ArrayList<>();
    }

    public void automate(){
        if(condition.evaluate()){
            for(Device device : devices){
                action.execute(device);
            }
        }
    }

    public int getAutomationRuleId() {
        return automationRuleId;
    }

    public void setAutomationRuleId(int automationRuleId) {
        this.automationRuleId = automationRuleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
