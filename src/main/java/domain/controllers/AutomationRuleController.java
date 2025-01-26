package domain.controllers;

import infrastructure.api.dto.AutomationRuleInput;
import domain.models.AutomationRule;
import infrastructure.persistence.adapters.AutomationRuleService;
import infrastructure.persistence.mapper.AutomationRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/automation_rules")
public class AutomationRuleController {

    private final AutomationRuleService automationRuleService;
    private final AutomationRuleMapper automationRuleMapper = AutomationRuleMapper.INSTANCE;

    @Autowired
    public AutomationRuleController(AutomationRuleService automationRuleService) {
        this.automationRuleService = automationRuleService;
    }

    @GetMapping
    public List<AutomationRule> getAllAutomationRules() {
        return automationRuleService.getAllAutomationRules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomationRule> getAutomationRuleById(@PathVariable long id) {
        AutomationRule automationRule = automationRuleService.getAutomationRuleById(id);
        if (automationRule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(automationRule);
    }

    @PostMapping
    public ResponseEntity<AutomationRule> createAutomationRule(@RequestBody AutomationRuleInput automationRuleInput) {
        AutomationRule automationRule = automationRuleMapper.inputToDomain(automationRuleInput);
        AutomationRule createdRule = automationRuleService.createAutomationRule(automationRule);
        return ResponseEntity.status(201).body(createdRule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutomationRule> updateAutomationRule(@PathVariable long id, @RequestBody AutomationRuleInput automationRuleInput) {
        AutomationRule automationRule = automationRuleMapper.inputToDomain(automationRuleInput);
        AutomationRule updatedRule = automationRuleService.updateAutomationRule(id, automationRule);
        if (updatedRule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutomationRule(@PathVariable long id) {
        boolean deleted = automationRuleService.deleteAutomationRule(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}