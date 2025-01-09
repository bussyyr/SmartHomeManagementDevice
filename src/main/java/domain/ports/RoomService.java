package domain.ports;

import domain.models.Room;
import domain.models.device.Device;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    Room createRoom(Room room);
    Room updateRoom(int id, Room room);
    boolean deleteRoom(int id);

    Optional<Room> getRoomById(int id);
    List<Room> getAllRooms();
    List<Device> getAllDevicesInRoom(int id);
}
