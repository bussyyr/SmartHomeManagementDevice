package infrastructure.adapters;

import domain.models.device.Device;
import infrastructure.persistence.entities.AutomationRuleEntity;
import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.entities.RoomEntity;
import infrastructure.persistence.repositories.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import mapper.AutomationRuleMapper;
import mapper.DeviceMapper;
import mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper = DeviceMapper.INSTANCE;
    private final RoomMapper roomMapper = RoomMapper.INSTANCE;
    private final AutomationRuleMapper automationRuleMapper = AutomationRuleMapper.INSTANCE;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device createDevice(Device device) {
        DeviceEntity entity = deviceMapper.domainToEntity(device);
        DeviceEntity savedEntity = deviceRepository.save(entity);
        return deviceMapper.entityToDomain(savedEntity);
    }

    public Device updateDevice(long id, Device device) {
        DeviceEntity existingEntity = deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Device with id " + id + " not found!"));

        RoomEntity roomEntity = roomMapper.domainToEntity(device.getRoom());
        existingEntity.setRoom(roomEntity);

        existingEntity.setStatus(device.isStatus());

        List<AutomationRuleEntity> automationRuleEntities = automationRuleMapper.domainsToEntities(device.getAutomationRules());
        existingEntity.setAutomationRules(automationRuleEntities);

        DeviceEntity updatedEntity = deviceRepository.save(existingEntity);
        return deviceMapper.entityToDomain(updatedEntity);
    }

    public boolean deleteDevice(long id) {
        if(deviceRepository.existsById(id)){
            deviceRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("Device with id " + id + " not found!");
        }
    }

    public Device getDeviceById(long id) {
        return deviceRepository.findById(id)
                .map(deviceMapper::entityToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Device not found!"));
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(deviceMapper::entityToDomain)
                .collect(Collectors.toList());
    }
}
