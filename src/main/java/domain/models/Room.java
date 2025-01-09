package domain.models;

import domain.models.device.Device;

import java.util.List;

public class Room {
    private int RoomId;
    private String name;
    private List<Device> devices;

    public Room(int roomId, String name, List<Device> devices) {
        this.RoomId = roomId;
        this.name = name;
        this.devices = devices;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
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
