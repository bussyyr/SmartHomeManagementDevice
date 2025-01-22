package application.dto;

public class AutomationRuleInput {

    private String name;
    private Long[] deviceIds;
    private ConditionInput condition;
    private ActionInput action;
}
