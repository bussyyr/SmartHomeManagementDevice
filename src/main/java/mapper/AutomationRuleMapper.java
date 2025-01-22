package mapper;

import application.dto.AutomationRuleInput;
import domain.models.AutomationRule;
import domain.models.device.Device;
import infrastructure.persistence.entities.AutomationRuleEntity;
import infrastructure.persistence.entities.DeviceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AutomationRuleMapper {
    AutomationRuleMapper INSTANCE = Mappers.getMapper(AutomationRuleMapper.class);

    AutomationRule entityToDomain(AutomationRuleEntity entity);
    AutomationRuleEntity domainToEntity(AutomationRule domain);

    AutomationRule inputToDomain(AutomationRuleInput input);
    AutomationRuleInput domainToInput(AutomationRule domain);

    List<AutomationRule> entitiesToDomains(List<AutomationRuleEntity> entities);
    List<AutomationRuleEntity> domainsToEntities(List<AutomationRule> domains);
}
