package application.dto;

public class DeviceInput {

    private String deviceType;
    private Float consumptionPerHour;
    private Long roomId;

    public DeviceInput() {}

    public DeviceInput(String deviceType, Float consumptionPerHour, Long roomId) {
        this.deviceType = deviceType;
        this.consumptionPerHour = consumptionPerHour;
        this.roomId = roomId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Float getConsumptionPerHour() {
        return consumptionPerHour;
    }

    public void setConsumptionPerHour(Float consumptionPerHour) {
        this.consumptionPerHour = consumptionPerHour;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
