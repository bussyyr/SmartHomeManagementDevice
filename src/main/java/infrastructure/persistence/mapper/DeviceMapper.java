package infrastructure.persistence.mapper;

import infrastructure.api.dto.DeviceInput;
import domain.models.device.Device;
import infrastructure.persistence.entities.DeviceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    // Entity ↔ Domain dönüşümleri
    Device entityToDomain(DeviceEntity entity);
    DeviceEntity domainToEntity(Device domain);

    // DTO ↔ Domain dönüşümleri
    Device inputToDomain(DeviceInput input);
    DeviceInput domainToInput(Device domain);

    //list
    List<Device> entitiesToDomains(List<DeviceEntity> entities);
    List<DeviceEntity> domainsToEntities(List<Device> domains);
}
