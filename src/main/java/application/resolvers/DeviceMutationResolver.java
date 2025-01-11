package application.resolvers;

import application.dto.DeviceInput;
import domain.models.device.Device;
import graphql.kickstart.tools.GraphQLMutationResolver;
import infrastructure.adapters.DeviceService;
import mapper.DeviceMapper;
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

    /// Mutation (bunun ici entity kaldi denicez olmadi final long int, final String mail falan diye hepsini tek tek de veririz)
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
