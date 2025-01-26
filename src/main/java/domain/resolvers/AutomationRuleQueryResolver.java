package domain.resolvers;

import domain.models.AutomationRule;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.persistence.adapters.AutomationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutomationRuleQueryResolver implements GraphQLQueryResolver{
    private final AutomationRuleService automationRuleService;

    @Autowired
    public AutomationRuleQueryResolver(AutomationRuleService automationRuleService) {
        this.automationRuleService = automationRuleService;
    }

    /// //Query ////
    public AutomationRule getAutomationRule(final long id) {
        return automationRuleService.getAutomationRuleById(id);
    }

    public List<AutomationRule> getAutomationRules() {
        return automationRuleService.getAllAutomationRules();
    }


}
