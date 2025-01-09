package domain.models.device;

import domain.models.Room;

public class SwitchableDevice extends Device {

    public SwitchableDevice(int deviceId, deviceType deviceType, double totalConsumptionPerHour , Room room) {
        super(deviceId, Device.deviceType.SWITCHABLE, totalConsumptionPerHour, room);
    }
}
