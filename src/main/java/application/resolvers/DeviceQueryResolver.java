package application.resolvers;

import domain.models.device.Device;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeviceQueryResolver implements GraphQLQueryResolver{
    private final DeviceService deviceService;

    @Autowired
    public DeviceQueryResolver(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /////Query///
    public Device getDeviceById(final long id) {
        return deviceService.getDeviceById(id);
    }

    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }



}
