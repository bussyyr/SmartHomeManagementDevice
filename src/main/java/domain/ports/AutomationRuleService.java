package domain.ports;

import domain.models.AutomationRule;

import java.util.List;
import java.util.Optional;

public interface AutomationRuleService {
    
    AutomationRule createAutomationRule(AutomationRule rule);
    AutomationRule updateAutomationRule(int id, AutomationRule newRule);
    boolean deleteAutomationRule(int id);

    Optional<AutomationRule> getAutomationRuleById(int id);
    List<AutomationRule> getAllAutomationRules();
}
