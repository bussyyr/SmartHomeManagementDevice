package domain.models.device;

import domain.models.Room;

public class AdjustableDevice extends Device{

    protected double level; // degree or ...

    public AdjustableDevice(int deviceId, deviceType deviceType, double totalConsumptionPerHour , Room room) {
        super(deviceId, Device.deviceType.ADJUSTABLE, totalConsumptionPerHour, room);
        this.level = 0;
    }

    public void decreaseLevel(double amount){
        this.level -= amount;
    }

    public void increaseLevel(double amount){
        this.level += amount;
    }


}
