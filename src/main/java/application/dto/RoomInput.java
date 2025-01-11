package application.dto;

public class RoomInput {
    private String roomName;

    public RoomInput() {}

    public RoomInput(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
