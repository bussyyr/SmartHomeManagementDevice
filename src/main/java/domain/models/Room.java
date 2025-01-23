package domain.models;

import domain.models.device.Device;

import java.util.List;

public class Room {
    private long RoomId;
    private String name;
    private List<Device> devices;

    public Room(long roomId, String name, List<Device> devices) {
        this.RoomId = roomId;
        this.name = name;
        this.devices = devices;
    }

    public long getRoomId() {
        return RoomId;
    }

    public void setRoomId(long roomId) {
        RoomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
