package infrastructure.adapters;

import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.repositories.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceEntity createDevice(DeviceEntity device) {
        return deviceRepository.save(device);
    }

    public DeviceEntity updateDevice(long id, DeviceEntity device) {
        Optional<DeviceEntity> existingUserOpt = deviceRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            DeviceEntity existingDevice = existingUserOpt.get();
            existingDevice.setAutomationRules(device.getAutomationRules());
            existingDevice.setRoom(device.getRoom());
            existingDevice.setStatus(device.isStatus());
            return deviceRepository.save(existingDevice);
        }else{
            throw new EntityNotFoundException("Device with id " + id + " not found!");
        }
    }

    public boolean deleteDevice(long id) {
        if(deviceRepository.existsById(id)){
            deviceRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("Device with id " + id + " not found!");
        }
    }

    public Optional<DeviceEntity> getDeviceById(long id) {
        return deviceRepository.findById(id);
    }

    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }
}
