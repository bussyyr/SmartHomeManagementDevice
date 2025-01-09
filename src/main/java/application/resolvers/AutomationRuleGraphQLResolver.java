package application.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.AutomationRuleService;
import infrastructure.persistence.entities.AutomationRuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutomationRuleGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final AutomationRuleService automationRuleService;

    @Autowired
    public AutomationRuleGraphQLResolver(AutomationRuleService automationRuleService) {
        this.automationRuleService = automationRuleService;
    }

    /// //Query ////
    public AutomationRuleEntity getAutomationRule(final long id) {
        return automationRuleService.getAutomationRuleById(id).orElseGet(null);
    }

    public List<AutomationRuleEntity> getAutomationRules() {
        return automationRuleService.getAllAutomationRules();
    }

    /// Mutation
    public AutomationRuleEntity createAutomationRule(final AutomationRuleEntity automationRule) {
        return automationRuleService.createAutomationRule(automationRule);
    }

    public AutomationRuleEntity updateAutomationRule(final long id, final AutomationRuleEntity automationRule) {
        return automationRuleService.updateAutomationRule(id, automationRule);
    }

    public boolean deleteAutomationRule(final long id) {
        return automationRuleService.deleteAutomationRule(id);
    }
}
