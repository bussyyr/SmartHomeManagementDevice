package application.resolvers;

import application.dto.RoomInput;
import domain.models.Room;
import graphql.kickstart.tools.GraphQLMutationResolver;
import infrastructure.adapters.RoomService;
import infrastructure.persistence.entities.RoomEntity;
import infrastructure.persistence.repositories.RoomRepository;
import mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMutationResolver implements GraphQLMutationResolver {
    private final RoomService roomService;
    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    @Autowired
    public RoomMutationResolver(RoomService roomService) {
        this.roomService = roomService;
    }

    /// ///Mutation
    public Room createRoom(RoomInput roomInput) {
        Room room = roomMapper.inputToDomain(roomInput);
        return roomService.createRoom(room);
    }

    public Room updateRoom(final long id, RoomInput roomInput) {
        Room room = roomMapper.inputToDomain(roomInput);
        return roomService.updateRoom(id, room);
    }

    public boolean deleteRoom(final long id) {
        return roomService.deleteRoom(id);
    }
}
