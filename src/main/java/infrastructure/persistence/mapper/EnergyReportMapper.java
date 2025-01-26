package infrastructure.persistence.mapper;

import infrastructure.api.dto.EnergyReportInput;
import domain.models.EnergyReport;
import infrastructure.persistence.entities.EnergyReportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnergyReportMapper {
    EnergyReportMapper INSTANCE = Mappers.getMapper(EnergyReportMapper.class);

    EnergyReport entityToDomain(EnergyReportEntity entity);
    EnergyReportEntity domainToEntity(EnergyReport domain);

    EnergyReport inputToDomain(EnergyReportInput input);
    EnergyReportInput domainToInput(EnergyReport domain);
}
