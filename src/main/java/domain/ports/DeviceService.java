package domain.ports;

import domain.models.device.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {

    Device createDevice(Device device);
    Device updateDevice(int id, Device device);
    boolean deleteDevice(int id);

    Optional<Device> getDeviceById(int id);

    List<Device> getAllDevice();
}
