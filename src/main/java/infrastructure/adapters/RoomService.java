package infrastructure.adapters;

import infrastructure.persistence.entities.RoomEntity;
import infrastructure.persistence.repositories.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public RoomEntity createRoom(RoomEntity room){
        return roomRepository.save(room);
    }

    public RoomEntity updateRoom(long id, RoomEntity room){
        Optional<RoomEntity> existingRoomOpt = roomRepository.findById(id);
        if(existingRoomOpt.isPresent()){
            RoomEntity existingRoom = existingRoomOpt.get();
            existingRoom.setName(room.getName());
            existingRoom.setDevices(room.getDevices());
            return roomRepository.save(existingRoom);
        }else{
            throw new EntityNotFoundException("Room with id " + id + " not found!");
        }
    }

    public boolean deleteRoom(long id){
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Room with id " + id + " not found!");
        }
    }

    public Optional<RoomEntity> getRoomById(long id){
        return roomRepository.findById(id);
    }

    public List<RoomEntity> getAllRooms(){
        return roomRepository.findAll();
    }

    //getAllDevicesInRoom icin private deviceRepository tanimlayip oradan cekebilirsin dedi
}
