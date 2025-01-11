package infrastructure.adapters;

import domain.models.Room;
import infrastructure.persistence.entities.RoomEntity;
import infrastructure.persistence.repositories.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

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
        existingEntity.setDevices(room.getDevices());

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
