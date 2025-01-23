package domain.ports;

import domain.models.AutomationRule;

import java.util.List;
import java.util.Optional;

public interface AutomationRuleService {
    
    AutomationRule createAutomationRule(AutomationRule rule);
    AutomationRule updateAutomationRule(long id, AutomationRule newRule);
    boolean deleteAutomationRule(long id);

    Optional<AutomationRule> getAutomationRuleById(long id);
    List<AutomationRule> getAllAutomationRules();
}
