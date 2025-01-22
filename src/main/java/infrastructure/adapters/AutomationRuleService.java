package infrastructure.adapters;

import domain.models.AutomationRule;
import infrastructure.persistence.entities.AutomationRuleEntity;
import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.entities.UserEntity;
import infrastructure.persistence.repositories.AutomationRuleRepository;
import jakarta.persistence.EntityNotFoundException;
import mapper.AutomationRuleMapper;
import mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutomationRuleService {
    private final AutomationRuleRepository automationRuleRepository;
    private final AutomationRuleMapper automationRuleMapper = AutomationRuleMapper.INSTANCE;
    private final DeviceMapper deviceMapper = DeviceMapper.INSTANCE;

    @Autowired
    public AutomationRuleService(AutomationRuleRepository automationRuleRepository){
        this.automationRuleRepository = automationRuleRepository;
    }

    public AutomationRule createAutomationRule(AutomationRule automationRule){
        AutomationRuleEntity entity = automationRuleMapper.domainToEntity(automationRule);
        AutomationRuleEntity savedEntity = automationRuleRepository.save(entity);
        return automationRuleMapper.entityToDomain(savedEntity);
    }

    public AutomationRule updateAutomationRule(long id, AutomationRule automationRule){
        AutomationRuleEntity existingEntity = automationRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Automation rule with id " + id + " not found!"));
        existingEntity.setName(automationRule.getName());

        List<DeviceEntity> deviceEntities = deviceMapper.domainsToEntities(automationRule.getDevices());
        existingEntity.setDevices(deviceEntities);

        AutomationRuleEntity updatedEntity = automationRuleRepository.save(existingEntity);
        return automationRuleMapper.entityToDomain(updatedEntity);
    }

    public boolean deleteAutomationRule(long id){
        if(automationRuleRepository.existsById(id)){
            automationRuleRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("Automation Rule with id " + id + " not found!");
        }
    }

    public AutomationRule getAutomationRuleById(long id){
        return automationRuleRepository.findById(id)
                .map(automationRuleMapper::entityToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Automation Rule not found!"));
    }

    public List<AutomationRule> getAllAutomationRules(){
        return automationRuleRepository.findAll()
                .stream().map(automationRuleMapper::entityToDomain)
                .collect(Collectors.toList());
    }
}
