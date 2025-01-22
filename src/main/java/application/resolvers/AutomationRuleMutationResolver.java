package application.resolvers;

import application.dto.AutomationRuleInput;
import domain.models.AutomationRule;
import graphql.kickstart.tools.GraphQLMutationResolver;
import infrastructure.adapters.AutomationRuleService;
import mapper.AutomationRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutomationRuleMutationResolver implements GraphQLMutationResolver {
    private final AutomationRuleService automationRuleService;
    private final AutomationRuleMapper automationRuleMapper = AutomationRuleMapper.INSTANCE;

    @Autowired
    public AutomationRuleMutationResolver(AutomationRuleService automationRuleService) {
        this.automationRuleService = automationRuleService;
    }

    /// Mutation
    public AutomationRule createAutomationRule(AutomationRuleInput automationRuleInput) {
        AutomationRule automationRule = automationRuleMapper.inputToDomain(automationRuleInput);
        return automationRuleService.createAutomationRule(automationRule);
    }

    public AutomationRule updateAutomationRule(final long id, AutomationRuleInput automationRuleInput) {
        AutomationRule automationRule = automationRuleMapper.inputToDomain(automationRuleInput);
        return automationRuleService.updateAutomationRule(id, automationRule);
    }

    public boolean deleteAutomationRule(final long id) {
        return automationRuleService.deleteAutomationRule(id);
    }
}
