package infrastructure.adapters;

import infrastructure.persistence.entities.AutomationRuleEntity;
import infrastructure.persistence.entities.UserEntity;
import infrastructure.persistence.repositories.AutomationRuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutomationRuleService {
    private final AutomationRuleRepository automationRuleRepository;

    @Autowired
    public AutomationRuleService(AutomationRuleRepository automationRuleRepository){
        this.automationRuleRepository = automationRuleRepository;
    }

    public AutomationRuleEntity createAutomationRule(AutomationRuleEntity automationRule){
        return automationRuleRepository.save(automationRule);
    }

    public AutomationRuleEntity updateAutomationRule(long id, AutomationRuleEntity automationRule){
        Optional<AutomationRuleEntity> existingAutomationRuleOpt = automationRuleRepository.findById(id);
        if(existingAutomationRuleOpt.isPresent()){
            AutomationRuleEntity existingAutomationRule = existingAutomationRuleOpt.get();
            existingAutomationRule.setName(automationRule.getName());
            existingAutomationRule.setDevices(automationRule.getDevices());
            return automationRuleRepository.save(existingAutomationRule);
        }else{
            throw new EntityNotFoundException("Automation Rule with id " + id + " not found!");
        }
    }

    public boolean deleteAutomationRule(long id){
        if(automationRuleRepository.existsById(id)){
            automationRuleRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("Automation Rule with id " + id + " not found!");
        }
    }

    public Optional<AutomationRuleEntity> getAutomationRuleById(long id){
        return automationRuleRepository.findById(id);
    }

    public List<AutomationRuleEntity> getAllAutomationRules(){
        return automationRuleRepository.findAll();
    }
}
