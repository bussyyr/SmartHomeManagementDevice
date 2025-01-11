package mapper;

import application.dto.RoomInput;
import domain.models.Room;
import infrastructure.persistence.entities.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    Room entityToDomain(RoomEntity entity);
    RoomEntity domainToEntity(Room domain);

    Room inputToDomain(RoomInput input);
    RoomInput domainToInput(Room domain);
}
