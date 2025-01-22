package infrastructure.adapters;

import domain.models.Room;
import domain.models.device.Device;
import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.entities.RoomEntity;
import infrastructure.persistence.repositories.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import mapper.DeviceMapper;
import mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper = RoomMapper.INSTANCE;
    private final DeviceMapper deviceMapper = DeviceMapper.INSTANCE;

    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Room room){
        RoomEntity entity = roomMapper.domainToEntity(room);
        RoomEntity savedEntity = roomRepository.save(entity);
        return roomMapper.entityToDomain(savedEntity);
    }

    public Room updateRoom(long id, Room room){
        RoomEntity existingEntity = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room with id " + id + " not found!"));

        existingEntity.setName(room.getName());
        List<DeviceEntity> deviceEntities = deviceMapper.domainsToEntities(room.getDevices());
        existingEntity.setDevices(deviceEntities);

        RoomEntity updatedEntity = roomRepository.save(existingEntity);
        return roomMapper.entityToDomain(updatedEntity);
    }

    public boolean deleteRoom(long id){
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Room with id " + id + " not found!");
        }
    }

    public Room getRoomById(long id){
        return roomRepository.findById(id)
                .map(roomMapper::entityToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Room with id " + id + " not found!"));
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    //getAllDevicesInRoom icin private deviceRepository tanimlayip oradan cekebilirsin dedi
}
