package infrastructure.adapters;

import domain.models.device.Device;
import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.repositories.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper = DeviceMapper.INSTANCE;

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

        existingEntity.setRoom(device.getRoom());
        existingEntity.setStatus(device.isStatus());
        existingEntity.setAutomationRules(device.getAutomationRules());

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
