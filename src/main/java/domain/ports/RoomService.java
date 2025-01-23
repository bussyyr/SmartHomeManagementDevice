package domain.ports;

import domain.models.Room;
import domain.models.device.Device;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    Room createRoom(Room room);
    Room updateRoom(long id, Room room);
    boolean deleteRoom(long id);

    Optional<Room> getRoomById(long id);
    List<Room> getAllRooms();
    List<Device> getAllDevicesInRoom(long id);
}
