package domain.resolvers;

import infrastructure.api.dto.DeviceInput;
import domain.models.device.Device;
import graphql.kickstart.tools.GraphQLMutationResolver;
import infrastructure.persistence.adapters.DeviceService;
import infrastructure.persistence.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceMutationResolver implements GraphQLMutationResolver {
    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper = DeviceMapper.INSTANCE;

    @Autowired
    public DeviceMutationResolver(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    public Device createDevice(DeviceInput deviceInput) {
        Device device = deviceMapper.inputToDomain(deviceInput);
        return deviceService.createDevice(device);
    }

    public Device updateDevice(final long id, DeviceInput deviceInput) {
        Device device = deviceMapper.inputToDomain(deviceInput);
        return deviceService.updateDevice(id, device);
    }

    public boolean deleteDevice(final long id) {
        return deviceService.deleteDevice(id);
    }
}
