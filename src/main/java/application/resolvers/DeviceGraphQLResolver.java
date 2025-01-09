package application.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.DeviceService;
import infrastructure.persistence.entities.DeviceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final DeviceService deviceService;

    @Autowired
    public DeviceGraphQLResolver(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /////Query///
    public DeviceEntity getDeviceById(final long id) {
        return deviceService.getDeviceById(id).orElseGet(null);
    }

    public List<DeviceEntity> getAllDevices() {
        return deviceService.getAllDevices();
    }

    /// Mutation (bunun ici entity kaldi denicez olmadi final long int, final String mail falan diye hepsini tek tek de veririz)
    public DeviceEntity createDevice(final DeviceEntity deviceEntity) {
        return deviceService.createDevice(deviceEntity);
    }

    public DeviceEntity updateDevice(final long id, final DeviceEntity deviceEntity) {
        return deviceService.updateDevice(id, deviceEntity);
    }

    public boolean deleteDevice(final long id) {
        return deviceService.deleteDevice(id);
    }

}
