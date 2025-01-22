package application.resolvers;

import domain.models.Room;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.RoomService;
import infrastructure.persistence.entities.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomQueryResolver implements GraphQLQueryResolver {
    private final RoomService roomService;

    @Autowired
    public RoomQueryResolver(RoomService roomService) {
        this.roomService = roomService;
    }

    //////Query
    public Room getRoomById(final long id) {
        return roomService.getRoomById(id);
    }

    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }



}
